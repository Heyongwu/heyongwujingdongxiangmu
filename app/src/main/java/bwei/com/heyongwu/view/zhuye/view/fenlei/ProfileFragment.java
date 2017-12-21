package bwei.com.heyongwu.view.zhuye.view.fenlei;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import bwei.com.heyongwu.R;
import bwei.com.heyongwu.ZiDingyi.widget.GlideImageLoader;
import bwei.com.heyongwu.ZiDingyi.widget.MyExpanableListView;
import bwei.com.heyongwu.adapter.LeftAdapter;
import bwei.com.heyongwu.adapter.RightAdapter;
import bwei.com.heyongwu.bean.Catagory;
import bwei.com.heyongwu.bean.ProductCatagoryBean;
import bwei.com.heyongwu.percenter.ClassPresenter;


public class ProfileFragment extends Fragment implements IPerson{
    private ListView mLvLeft;
    private ClassPresenter classPresenter;
    private LeftAdapter adapter;
    private List<String> groupList = new ArrayList<>();//一级列表数据
    private List<List<ProductCatagoryBean.DataBean.ListBean>> childList = new ArrayList<>();//二级列表
    private Banner banner;
    private MyExpanableListView mElv;
    private View view;
    private String cid="1";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.profile, container, false);
        classPresenter = new ClassPresenter(this);
        classPresenter.getCatagory();
        initView();

        mLvLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.press(position);
                //请求对应右侧的数据
                //获取cid
                Catagory.DataBean dataBean= (Catagory.DataBean) parent.getItemAtPosition(position);
                int cid=dataBean.getCid();

                classPresenter.getProductCatagory(cid+"");

            }
        });

        return view;
    }

    private void initView() {

        mLvLeft =  view.findViewById(R.id.lv_left);
        banner =  view.findViewById(R.id.banner);
        mElv =  view.findViewById(R.id.elv);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        List<String> images=new ArrayList<>();
        images.add("http://omsproductionimg.yangkeduo.com/images/2017-11-16/65ecd4474f0c48cfb657721109074ac1.jpeg");
        images.add("http://omsproductionimg.yangkeduo.com/images/2017-11-16/4b87d55ecb22a96675587fd9be695470.jpeg");
        images.add("http://omsproductionimg.yangkeduo.com/images/2017-11-16/06da32ea9c5147cfb4368275b474b2b8.jpeg");
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }


    @Override
    public void showData(List<Catagory.DataBean> list) {
        adapter = new LeftAdapter(getActivity(),list);
        mLvLeft.setAdapter(adapter);
    }

    @Override
    public void showElvData(List<ProductCatagoryBean.DataBean> list) {
        groupList.clear();
        childList.clear();
        //给二级列表封住数据
        for(int i=0;i<list.size();i++){
            ProductCatagoryBean.DataBean dataBean=list.get(i);
            groupList.add(dataBean.getName());
            childList.add(dataBean.getList());
        }

        //创建适配器
        RightAdapter rightAdapter = new RightAdapter(this.getActivity(), childList, groupList);
        mElv.setAdapter(rightAdapter);
        //设置默认全部展开
        for (int i = 0; i < list.size(); i++) {
            mElv.expandGroup(i);
        }

    }
}