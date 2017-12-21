package bwei.com.heyongwu.view.zhuye.view.fenlei;

import bwei.com.heyongwu.network.Api;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetorfitHelper {
      public static OkHttpClient okHttpClient;
    public static ServiceAPIS serverApi;
     static
     {
         initOkHttpClient();
     }

      public static OkHttpClient initOkHttpClient()
      {
          if(okHttpClient==null)
          {
              synchronized (RetorfitHelper.class)
              {
                  if(okHttpClient==null)
                  {
                      okHttpClient=new OkHttpClient();
                  }
              }
          }
          return okHttpClient;
      }

      public static ServiceAPIS getServerApi()
      {
          if(serverApi==null)
          {
              synchronized (ServiceAPIS.class)
              {
                  if(serverApi==null)
                  {
                      serverApi=OnCreatApi(ServiceAPIS.class, Api.HOST);
                  }
              }
          }
          return serverApi;
      }
      public static<T> T OnCreatApi(Class<T> tClass,String url)
      {

          Retrofit retrofit=new Retrofit.Builder()
                            .baseUrl(url)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

          return retrofit.create(tClass);
      }
}

