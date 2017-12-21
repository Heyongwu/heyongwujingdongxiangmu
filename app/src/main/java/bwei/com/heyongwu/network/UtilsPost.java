package bwei.com.heyongwu.network;



import java.util.List;
import java.util.Map;

import bwei.com.heyongwu.bean.My_ListBean;
import bwei.com.heyongwu.bean.My_RetBean;
import bwei.com.heyongwu.bean.My_VideoBean;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Yw_Ambition on 2017/11/9.
 */

public interface UtilsPost {
    @GET("front/columns/getVideoList.do")
    Flowable<My_VideoBean<My_RetBean<List<My_ListBean>>>> getVideo(@QueryMap Map<String, String> map);

}
