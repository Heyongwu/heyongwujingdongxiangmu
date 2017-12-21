package bwei.com.heyongwu.view.zhuye.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import bwei.com.heyongwu.R;


/**
 * Created by Liu xiong biao on 2017/11/9.
 */

public class TitleView extends LinearLayout {
    public TitleView(Context context) {
        this(context,null);

    }

    public TitleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TitleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = View.inflate(context, R.layout.shouyetitle, this);
    }


}
