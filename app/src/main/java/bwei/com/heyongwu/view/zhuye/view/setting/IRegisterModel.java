package bwei.com.heyongwu.view.zhuye.view.setting;


import bwei.com.heyongwu.bean.LoginBean;
import bwei.com.heyongwu.network.OnNetListener;

/**
 * Created by 何永武 on 2017/11/15.
 */

public interface IRegisterModel {
    public void register(String account, String pwd, OnNetListener<LoginBean> onNetListener);
}
