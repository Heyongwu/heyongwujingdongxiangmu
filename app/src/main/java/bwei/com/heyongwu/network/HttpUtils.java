package bwei.com.heyongwu.network;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import bwei.com.heyongwu.ZiDingyi.LoggingInterceptor;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by dang on 2017/11/7.
 * 网络请求工具类
 */

public class HttpUtils {
    private static HttpUtils httpUtils;
    private OkHttpClient client;
    private HttpUtils(){

        //调用现成的拦截器
        client=new OkHttpClient.Builder().addInterceptor(new LoggingInterceptor())
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .build();
    }
    public static HttpUtils getHttpUtils(){
        if(httpUtils==null){
            synchronized (HttpUtils.class){
                if(httpUtils==null){
                    httpUtils=new HttpUtils();
                }
            }
        }
             return httpUtils;
    }
    //get请求
    public void doGet(String url,Callback callback){
        Request request=new Request.Builder().url(url).build();
        client.newCall(request).enqueue(callback);
    }
    /**
     * POST请求
     * url      请求地址
     * params   请求的参数
     * callback 回调
     */
    public void doPost(String url, Map<String,String> params, Callback callback){
        //判断参数
        if(params==null||params.size()==0){
            throw new RuntimeException("参数不能为空");
        }
        //创建Request
        FormBody.Builder builder=new FormBody.Builder();
        for (Map.Entry<String,String> entry:params.entrySet()) {
            builder.add(entry.getKey(),entry.getValue());
        }
        FormBody formBody=builder.build();
        Request request=new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        client.newCall(request).enqueue(callback);
    }
}
