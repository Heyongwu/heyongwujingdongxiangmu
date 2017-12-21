package bwei.com.heyongwu.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import bwei.com.heyongwu.R;
import bwei.com.heyongwu.bean.ChildBean;


public class GvAdapter extends BaseAdapter{
    private Context context;
    private List<ChildBean> list;

    public GvAdapter(Context context, List<ChildBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        holder h;
        if(view==null){
            h=new holder();
            view=View.inflate(context, R.layout.view_gridview,null);
            h.img=view.findViewById(R.id.img_gv);
            h.text=view.findViewById(R.id.text_gv);
            view.setTag(h);
        }else{
            h= (holder) view.getTag();
        }
        h.text.setText(list.get(i).getName());
        Glide.with(context).load(list.get(i).getImgurl()).into(h.img);
        return view;
    }

    class holder{
        ImageView img;
        TextView text;
    }
}
