package bwei.com.heyongwu.view.zhuye.view;

import android.content.Context;
import android.widget.ImageView;

import com.youth.banner.loader.ImageLoader;



public class ImgApp extends ImageLoader {

   @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
       com.nostra13.universalimageloader.core.ImageLoader.getInstance().displayImage((String) path,imageView);
    }
}
