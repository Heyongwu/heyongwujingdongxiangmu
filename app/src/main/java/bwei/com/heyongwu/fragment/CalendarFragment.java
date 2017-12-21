package bwei.com.heyongwu.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bwei.com.heyongwu.R;
import bwei.com.heyongwu.adapter.CarAdapter;
import bwei.com.heyongwu.bean.AddBean;
import bwei.com.heyongwu.bean.CarBean;
import bwei.com.heyongwu.bean.ChildBean;
import bwei.com.heyongwu.bean.LeftBean;
import bwei.com.heyongwu.percenter.GetUser;
import bwei.com.heyongwu.percenter.JrGwcPrecenter;
import bwei.com.heyongwu.view.zhuye.view.ImgApp2;
import bwei.com.heyongwu.view.zhuye.view.setting.MyLoginActivity;

public class CalendarFragment extends Fragment implements GetUser {
    private View view;
    private ExpandableListView ev;
    public CheckBox cb;
    public TextView sum;
    private List<LeftBean> list=new ArrayList<>();;
    private List<List<ChildBean>> lists=new ArrayList<>();;
    private CarAdapter adapter;
    private Button delete;
    private JrGwcPrecenter presenter;
    private Button hide;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.calendar, container, false);

        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        hide =(Button) view.findViewById(R.id.btn_hide);
        ev = (ExpandableListView) view.findViewById(R.id.ev);
        cb = (CheckBox)  view.findViewById(R.id.cb_all);
        sum = (TextView)  view.findViewById(R.id.sum);
        delete = (Button) view.findViewById(R.id.btn_del);
        //新建适配器
        adapter = new CarAdapter(getActivity(), list, lists,this);
        ev.setAdapter(adapter);
        //跳转登录
        hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //App.sp.getBoolean("isLogin",false)
                if(ImgApp2.sp.getBoolean("isLogin",false)==false){
                    Intent intent=new Intent(getActivity(), MyLoginActivity.class);
                    getActivity().startActivity(intent);
                }
            }
        });
        //全选按钮点击事件
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0;i<list.size();i++){
                    list.get(i).setIsflag(cb.isChecked());
                }
                for(int i=0;i<lists.size();i++){
                    for(int j=0;j<lists.get(i).size();j++){
                        lists.get(i).get(j).setIsflag(cb.isChecked());
                    }
                }
                int n=0;
                for (int j=0;j<lists.size();j++){
                    List<ChildBean> beanList = lists.get(j);
                    for (int k=0;k<beanList.size();k++){
                        if(beanList.get(k).isflag()){
                            int num = beanList.get(k).getNum();
                            double price1 = beanList.get(k).getPrice();
                            n+=price1*num;
                        }
                    }
                }
                sum.setText("总价为:"+n);
                //刷新适配器
                adapter.notifyDataSetChanged();
            }
        });

        //删除按钮点击事件
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0;i<lists.size();i++){
                    List<ChildBean> beanList = lists.get(i);
                    for (int j=0;j<beanList.size();j++){
                        ChildBean bean = beanList.get(j);
                        if (bean.isflag()){
                            String pid = bean.getPid();
                            lists.get(i).remove(j);
                            Map<String,String> map1=new HashMap<String, String>();
                            map1.put("uid", ImgApp2.sp.getString("userid", ""));
                            map1.put("pid",pid);
                            presenter.getshow("http://120.27.23.105/product/deleteCart",map1, AddBean.class,"2");
                            mouth(CalendarFragment.this);
                        }
                    }
                    if (lists.get(i).size()==0){
                        lists.remove(i);
                        list.remove(i);
                    }

                }
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void init() {
        //通过p层获取数据
        presenter = new JrGwcPrecenter(this);
        Map<String,String> map=new HashMap<>();
        map.put("uid",   ImgApp2.sp.getInt("uid", 0)+"");
        presenter.getshow("http://120.27.23.105/product/getCarts?source=android",map,CarBean.class,"1");
    }
    //判断是否全选
    public boolean setcheck(){
        boolean b=true;
        for (int i=0;i<list.size();i++){
            if (!list.get(i).isflag()){
                b=list.get(i).isflag();
                break;
            }
            List<ChildBean> beanList = lists.get(i);
            for(int j=0;j<beanList.size();j++){
                if (!beanList.get(j).isflag()){
                    b=beanList.get(j).isflag();
                    break;
                }
            }
        }
        return b;
    }
    //计算总价的方法
    public void mouth(CalendarFragment f){
        float n=0;
        for (int j=0;j<lists.size();j++){
            List<ChildBean> beanList = lists.get(j);
            for (int k=0;k<beanList.size();k++){
                if(beanList.get(k).isflag()){
                    int num = beanList.get(k).getNum();
                    double price1 = beanList.get(k).getPrice();
                    n+=price1*num;
                }
            }
        }
        f.sum.setText("总价为:"+n);
    }

    @Override
    public void getbean(Object o, String tag) {
        if (tag.equals("1")){
            if (o!=null){
                CarBean a = (CarBean)o;
                List<CarBean.DataBean> beanList = a.getData();
                //建立数据源
                for(int i=0;i<beanList.size();i++){
                    String name = beanList.get(i).getSellerName();
                    list.add(new LeftBean(name,false));
                    List<CarBean.DataBean.ListBean> listBeen = beanList.get(i).getList();
                    for(int j=0;j<listBeen.size();j++){
                        double price = listBeen.get(j).getPrice();
                        String s = listBeen.get(j).getImages();
                        String[] strings = s.split("!");
                        String title = listBeen.get(j).getTitle();
                        int id = listBeen.get(j).getPid();
                        int num = listBeen.get(j).getNum();
                        List<ChildBean> l=new ArrayList<>();
                        l.add(new ChildBean(title,strings[0],id+"",price,false,num));
                        lists.add(l);
                    }
                    //默认展开
                    for(int s = 0; s < adapter.getGroupCount(); s++){
                        ev.expandGroup(s);
                    }
                    //刷新适配器
                    adapter.notifyDataSetChanged();
                }
            }
        }else if(tag.equals("2")){
            AddBean bean = (AddBean) o;
            Log.e("ssss", bean.getMsg() );
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        lists.clear();
        list.clear();
        adapter.notifyDataSetChanged();
        if (ImgApp2.sp.getBoolean("isLogin",false)){
            hide.setVisibility(View.INVISIBLE);
            ev.setVisibility(View.VISIBLE);
            init();
        }else {
            hide.setVisibility(View.VISIBLE);
            ev.setVisibility(View.INVISIBLE);
        }
    }
}