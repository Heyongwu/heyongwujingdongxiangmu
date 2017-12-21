package bwei.com.heyongwu.model;


import bwei.com.heyongwu.bean.Catagory;
import bwei.com.heyongwu.bean.ProductCatagoryBean;
import bwei.com.heyongwu.network.OnNetListener;

/**
 * Created by dang on 2017/11/9.
 */

public interface IClassModel {
    public void getCatagory(OnNetListener<Catagory> onNetListener);
    public void getProductCatagory(String cid, OnNetListener<ProductCatagoryBean> onNetListener);
}
