package bwei.com.heyongwu.model;


import bwei.com.heyongwu.bean.GoodBean;
import bwei.com.heyongwu.network.OnNetListener;

/**
 * Created by Yw_Ambition on 2017/11/9.
 */

public interface IcartModel {
    public void getGoods(String uid, OnNetListener<GoodBean>onNetListener);
}
