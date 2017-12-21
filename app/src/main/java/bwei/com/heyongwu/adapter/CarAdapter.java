package bwei.com.heyongwu.adapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import bwei.com.heyongwu.R;
import bwei.com.heyongwu.bean.ChildBean;
import bwei.com.heyongwu.bean.LeftBean;
import bwei.com.heyongwu.fragment.CalendarFragment;
import bwei.com.heyongwu.xiaodongxi.Addview;

public class CarAdapter extends BaseExpandableListAdapter{
    private Context context;
    private List<LeftBean> list;
    private List<List<ChildBean>> lists;
    private CalendarFragment f;
    public CarAdapter(Context context, List<LeftBean> list, List<List<ChildBean>> lists, CalendarFragment f) {
        this.context = context;
        this.list = list;
        this.lists = lists;
        this.f=f;
    }

    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return lists.get(i).size();
    }

    @Override
    public Object getGroup(int i) {
        return list.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return lists.get(i).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public View getGroupView(final int i, boolean b, View view, ViewGroup viewGroup) {
        final LeftBean fatherbean = list.get(i);
        final List<ChildBean> childbeen = lists.get(i);
        view = View.inflate(this.context, R.layout.view_father_car, null);
        TextView textView = (TextView) view.findViewById(R.id.title_father_car);
        final CheckBox checkBox = (CheckBox) view.findViewById(R.id.cb_father_car);
        textView.setText(fatherbean.getName());
        checkBox.setChecked(fatherbean.isflag());
        //复选框点击事件
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = checkBox.isChecked();
                fatherbean.setIsflag(checked);
                for (int j=0;j<childbeen.size();j++){
                    childbeen.get(j).setIsflag(checked);
                }
                //计算总价方法
                f.mouth(f);
                boolean setcheck = f.setcheck();
                f.cb.setChecked(setcheck);
                notifyDataSetChanged();
            }
        });

        return view;
    }

    @Override
    public View getChildView(final int i, final int i1, boolean b, View view, ViewGroup viewGroup) {
        final ChildBean bean = lists.get(i).get(i1);
        //加载布局
        view= View.inflate(context, R.layout.view_child_car,null);
        //获取构件
        ImageView img = (ImageView) view.findViewById(R.id.child_img);
        TextView title = (TextView) view.findViewById(R.id.child_tit);
        Addview addview = (Addview) view.findViewById(R.id.addview);
        final TextView price = (TextView) view.findViewById(R.id.child_price);
        final CheckBox checkBox = (CheckBox) view.findViewById(R.id.cb_child);
        //修改内容
        addview.setNumber(bean.getNum());
        price.setText(bean.getPrice()+"");
        title.setText(bean.getName());
        checkBox.setChecked(lists.get(i).get(i1).isflag());
        Glide.with(context).load(bean.getImgurl()).into(img);
        //加减器点击事件
        addview.setOnAddDeleteClick(new Addview.OnAddDeleteClickListener() {
            @Override
            public void onAddClick(View v) {
                int num = bean.getNum();
                num++;
                bean.setNum(num);
                //计算总价方法
                f.mouth(f);
                notifyDataSetChanged();
            }
            @Override
            public void onDelClick(View v) {
                int num = bean.getNum();
                if(num>1){
                    num--;
                }
                bean.setNum(num);
                //计算总价方法
                f.mouth(f);
                notifyDataSetChanged();
            }
        });

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = checkBox.isChecked();
                lists.get(i).get(i1).setIsflag(checked);
                boolean b=true;
                if (checked){
                    for (int j=0;j<lists.get(i).size();j++){
                        boolean flag = lists.get(i).get(j).isflag();
                        if (flag==false){
                            b=false;
                        }
                    }
                    //修改父级的选中状态
                    if (b){
                        list.get(i).setIsflag(true);
                    }
                }else{
                    list.get(i).setIsflag(false);
                }
                //计算总价方法
                f.mouth(f);
                boolean setcheck = f.setcheck();
                f.cb.setChecked(setcheck);
                notifyDataSetChanged();
            }
        });
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
    @Override
    public boolean hasStableIds() {
        return true;
    }
}
