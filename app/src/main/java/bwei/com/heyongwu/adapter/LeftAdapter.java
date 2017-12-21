package bwei.com.heyongwu.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import bwei.com.heyongwu.R;
import bwei.com.heyongwu.bean.Catagory;

/**
 * Created by Yw_Ambition on 2017/12/12.
 */

public class LeftAdapter extends BaseAdapter{
    private Context context;
    private List<Catagory.DataBean> list;

    public LeftAdapter(Context context, List<Catagory.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHoder hoder;
        if(convertView==null){
            hoder=new ViewHoder();
            view=View.inflate(context, R.layout.left_item,null);
            hoder.tv= (TextView) view.findViewById(R.id.tv);
            view.setTag(hoder);
        }else {
            view=convertView;
            hoder= (ViewHoder) view.getTag();
        }
        Catagory.DataBean dataBean=list.get(position);
        hoder.tv.setText(dataBean.getName());
        //自己加的属性，判断是否选中
        if(dataBean.isChecked()){
            hoder.tv.setBackgroundColor(Color.parseColor("#EEEEEE"));
            hoder.tv.setTextColor(Color.parseColor("#FF0000"));
        }else {
            hoder.tv.setBackgroundColor(Color.parseColor("#ffffff"));
            hoder.tv.setTextColor(Color.parseColor("#FF262426"));
        }
        return view;
    }
    class ViewHoder{
        TextView tv;
    }
    //条目点击变色
    public void press(int position){
        //遍历,使所有的选项是未选中状态
        for(int i=0;i<list.size();i++){
            Catagory.DataBean dataBean=list.get(i);
            dataBean.setChecked(false);
        }
        //选中的变为true
        Catagory.DataBean dataBean=list.get(position);
        dataBean.setChecked(true);
        notifyDataSetChanged();

    }
}
