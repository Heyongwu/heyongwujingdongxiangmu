package bwei.com.heyongwu.network;

import java.util.Map;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Yw_Ambition on 2017/12/14.
 */

public class HttpUrtil {
    private static HttpUrtil httpUtils;
    private final OkHttpClient client;

    private HttpUrtil() {
        client = new OkHttpClient.Builder().build();
    }
    public static HttpUrtil getHttpUtils(){
        if(httpUtils == null){
            synchronized (HttpUrtil.class){
                if(httpUtils == null){
                    httpUtils = new HttpUrtil();
                }
            }
        }
        return httpUtils;
    }
    public void doGet(String url, Callback callback){
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(callback);
    }
    public void doPost(String url, Map<String,String> params, Callback callback){
        FormBody.Builder builder = new FormBody.Builder();
        for(Map.Entry<String,String > entry:params.entrySet()){
            builder.add(entry.getKey(),entry.getValue());
        }
        FormBody build = builder.build();
        Request request = new Request.Builder().url(url).post(build).build();
        client.newCall(request).enqueue(callback);
    }
}
