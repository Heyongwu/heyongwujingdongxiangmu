package bwei.com.heyongwu.adapter;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;

import bwei.com.heyongwu.R;
import bwei.com.heyongwu.bean.ChildBean;
import bwei.com.heyongwu.bean.LeftBean;
import bwei.com.heyongwu.xiaodongxi.MyView;

/**
 * author:Created by MaYue on.
 */

public class EVadapter extends BaseExpandableListAdapter {
    private Context context;
    private List<LeftBean> fatherlist;
    private List<List<ChildBean>> childlist;

    public EVadapter(Context context, List<LeftBean> fatherlist, List<List<ChildBean>> childlist) {
        this.context = context;
        this.fatherlist = fatherlist;
        this.childlist = childlist;
    }

    @Override
    public int getGroupCount() {
        return fatherlist.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return 1;
    }

    @Override
    public Object getGroup(int i) {
        return fatherlist.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return childlist.get(i).get(i1);
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
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        holder h;
        if (view==null){
            h=new holder();
            view=View.inflate(context, R.layout.view_father,null);
            h.title=view.findViewById(R.id.text_father);
            view.setTag(h);
        }else{
            h= (holder) view.getTag();
        }
        h.title.setText(fatherlist.get(i).getName());
        return view;
    }

    @Override
    public View getChildView(final int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        holder h1;
        final List<ChildBean> beanList = childlist.get(i);
        if(view==null){
            h1=new holder();
            view=View.inflate(context,R.layout.view_child,null);
            h1.gv=view.findViewById(R.id.gv);
            view.setTag(h1);
        }else{
            h1= (holder) view.getTag();
        }
        h1.gv.setAdapter(new GvAdapter(context,beanList));
        h1.gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int j, long l) {
                String pid =beanList.get(j).getPid();
                Intent intent = new Intent(context, ListActivity.class);
                intent.putExtra("pscid",pid);
                context.startActivity(intent);
            }
        });
        return view;
    }

    class  holder{
        TextView title;
        MyView gv;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
    @Override
    public boolean hasStableIds() {
        return false;
    }
}
