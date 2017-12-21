package bwei.com.heyongwu.view.zhuye.view.setting;


import bwei.com.heyongwu.bean.LoginBean;
import bwei.com.heyongwu.network.OnNetListener;

/**
 * Created by 何永武 on 2017/11/14.
 */

public interface ILoginModel {
    public void Login(String account, String pwd, OnNetListener<LoginBean> onNetListener);
}
