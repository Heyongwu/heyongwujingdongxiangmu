package bwei.com.heyongwu.xiaodongxi;


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import bwei.com.heyongwu.R;


public class Addview extends RelativeLayout {
    public TextView count;

    public Addview(Context context) {
        this(context,null);
    }

    public Addview(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Addview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs, defStyleAttr);
    }

    private OnAddDeleteClickListener listener;

    //对外提供一个点击的回调接口
    public interface OnAddDeleteClickListener{
        void onAddClick(View v);
        void onDelClick(View v);
    }

    public void setOnAddDeleteClick(OnAddDeleteClickListener listener){
        this.listener = listener;
    }

    private void initView(final Context context, AttributeSet attrs, int defStyleAttr) {
        View view = View.inflate(context, R.layout.view_add, this);
        ImageView delete = (ImageView)view.findViewById(R.id.delete);
        count = (TextView)view.findViewById(R.id.count);
        ImageView add = (ImageView)view.findViewById(R.id.add);
        delete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onDelClick(view);
            }
        });
        add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onAddClick(view);
            }
        });
    }

    //对外提供设置EditText值的方法
    public void setNumber(int number){
        count.setText(number + "");
    }
    //得到控件原来的值,并转成int类型
    public int getNumber(){
        int number = Integer.parseInt(count.getText().toString().trim());
        return number;
    }
}
