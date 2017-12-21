package bwei.com.heyongwu.view.zhuye.view;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import bwei.com.heyongwu.xiaodongxi.CrashHandler;

public class ImgApp2 extends Application {
    public static SharedPreferences sp;
    public static SharedPreferences.Editor edit;
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        sp = getSharedPreferences("UserID", Context.MODE_APPEND);
        edit = sp.edit();
        ImageLoaderConfiguration build = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(build);
        CrashHandler handler = CrashHandler.getInstance();
        handler.init(getApplicationContext()); //在Appliction里面设置我们的异常处理器为UncaughtExceptionHandler处理器
    }
}
