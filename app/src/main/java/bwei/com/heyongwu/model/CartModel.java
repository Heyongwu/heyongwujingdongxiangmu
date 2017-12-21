package bwei.com.heyongwu.model;


import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import bwei.com.heyongwu.bean.GoodBean;
import bwei.com.heyongwu.network.Api;
import bwei.com.heyongwu.network.HttpUtils;
import bwei.com.heyongwu.network.OnNetListener;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by DangByMySide on 2017/12/7.
 */

public class CartModel extends BaseModel implements IcartModel{

    @Override
    public void getGoods(String uid, final OnNetListener<GoodBean> onNetListener) {
        Map<String,String> map =new HashMap<>();
        map.put("uid",uid);
        HttpUtils.getHttpUtils().doPost(Api.url,map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                final GoodBean goodBean = new Gson().fromJson(string, GoodBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onSuccess(goodBean);
                    }
                });
            }
        });
    }
}
