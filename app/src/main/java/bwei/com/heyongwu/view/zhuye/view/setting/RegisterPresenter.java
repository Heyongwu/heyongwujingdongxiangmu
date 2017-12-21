package bwei.com.heyongwu.view.zhuye.view.setting;

import bwei.com.heyongwu.bean.LoginBean;
import bwei.com.heyongwu.network.OnNetListener;

;

/**
 * Created by 何永武 on 2017/11/15.
 */

public class RegisterPresenter {
    private static IRegisterActivity iRegisterActivity;
    private final IRegisterModel iregisterModel;

    public RegisterPresenter(IRegisterActivity iRegisterActivity) {
        this.iRegisterActivity = iRegisterActivity;
        iregisterModel = new RegisterModel();
    }
    public void register(){
        String account = iRegisterActivity.getAccount();
        String pwd = iRegisterActivity.getPwd();
        iregisterModel.register(account, pwd, new OnNetListener<LoginBean>() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                iRegisterActivity.show(loginBean.getMsg());
                iRegisterActivity.ToLogin();
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
