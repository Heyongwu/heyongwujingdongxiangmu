package bwei.com.heyongwu.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Yw_Ambition on 2017/11/9.
 */

public class RetrofitUtils {
    private static volatile RetrofitUtils instance;
    private final Retrofit retrofit;

    private RetrofitUtils(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://api.svipmovie.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RetrofitUtils getInstance(){
        if(instance==null){
            synchronized (RetrofitUtils.class){
                if(instance==null){
                    instance=new RetrofitUtils();
                }
            }
        }
        return instance;
    }


    public UtilsPost getApiservise(){
        return retrofit.create(UtilsPost.class);
    }
}
