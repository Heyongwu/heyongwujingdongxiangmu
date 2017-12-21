package bwei.com.heyongwu;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class MyFontTextView extends TextView {

    public MyFontTextView(Context context) {
        super(context);
        init(context);
        // TODO Auto-generated constructor stub
    }

    public MyFontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
        // TODO Auto-generated constructor stub
    }

    public MyFontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        // TODO Auto-generated constructor stub
    }

    private void init(Context context) {
        // TODO Auto-generated method stub
        AssetManager aManager=context.getAssets();
        Typeface font=Typeface.createFromAsset(aManager, "font/english.ttf");
        setTypeface(font);
    }
}