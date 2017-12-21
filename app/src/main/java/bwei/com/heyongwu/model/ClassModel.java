package bwei.com.heyongwu.model;


import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import bwei.com.heyongwu.bean.Catagory;
import bwei.com.heyongwu.bean.ProductCatagoryBean;
import bwei.com.heyongwu.network.Api;
import bwei.com.heyongwu.network.HttpUtils;
import bwei.com.heyongwu.network.OnNetListener;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class ClassModel extends BaseModel implements IClassModel{

    @Override
    public void getCatagory(final OnNetListener<Catagory> onNetListener) {

            HttpUtils.getHttpUtils().doGet(Api.CLASS, new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onFailure(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string=response.body().string();
                final Catagory catagory=new Gson().fromJson(string,Catagory.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onSuccess(catagory);
                    }
                });
            }
        });
    }

    @Override
    public void getProductCatagory(String cid, final OnNetListener<ProductCatagoryBean> onNetListener) {
        Map<String,String> params=new HashMap<>();
        params.put("cid",cid);
        HttpUtils.getHttpUtils().doPost(Api.PRODUCT_CATAGORY, params, new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onFailure(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string=response.body().string();
                final ProductCatagoryBean productCatagoryBean=new Gson().fromJson(string,ProductCatagoryBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onSuccess(productCatagoryBean);
                    }
                });
            }
        });

    }
}
