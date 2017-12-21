package bwei.com.heyongwu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import bwei.com.heyongwu.R;


/**
 * Created by Yw_Ambition on 2017/11/9.
 */

public class SouSuoVerticalRvAdapter  extends RecyclerView.Adapter<SouSuoVerticalRvAdapter.ViewHolder> {

    private Context context;
    private List<String> list;


    public SouSuoVerticalRvAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.sousuoverticalrvitem, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String s = list.get(position);

        holder.textView.setText(s);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private  TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.sousuoverticaltv);
        }
    }
}
