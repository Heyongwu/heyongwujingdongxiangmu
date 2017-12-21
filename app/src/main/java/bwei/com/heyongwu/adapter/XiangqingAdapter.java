package bwei.com.heyongwu.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import bwei.com.heyongwu.R;
import bwei.com.heyongwu.bean.XqBean;

/**
 * Created by Yw_Ambition on 2017/12/15.
 */

public class XiangqingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<XqBean.DataBean> list;
    private Context context;
    private View view;

    public XiangqingAdapter(List<XqBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        view =  LayoutInflater.from(context).inflate(R.layout.xiangqing_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            MyViewHolder myViewHolder = (MyViewHolder) holder;
            XqBean.DataBean dataBean = list.get(position);
            String images = dataBean.getImages();
            String[] split = images.split("!");
            String title = dataBean.getTitle();
            double price = dataBean.getPrice();
            myViewHolder.sdv.setImageURI(Uri.parse(split[0]));
            myViewHolder.tv.setText(title);
            myViewHolder.price.setText("￥"+price);
            

    }
    @Override
    public int getItemCount() {
        if (list== null) {
            return 0;
        }
        return list.size();
    }



    class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView sdv;

        private final TextView tv;
        private final TextView price;


        public MyViewHolder(View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.xiangq_sdv);

            tv = itemView.findViewById(R.id.xiangq_tv);
            price = itemView.findViewById(R.id.xiangq_price);

        }
    }

}
