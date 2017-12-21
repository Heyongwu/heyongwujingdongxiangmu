package bwei.com.heyongwu.view.zhuye.view.setting;

import bwei.com.heyongwu.bean.LoginBean;
import bwei.com.heyongwu.network.OnNetListener;

/**
 * Created by 何永武 on 2017/11/14.
 */

public class LoginPresenter {
    private IloginActivity iloginActivity;
    private final ILoginModel iloginModel;

    public LoginPresenter(IloginActivity iloginActivity) {
        this.iloginActivity = iloginActivity;
        iloginModel = new LoginModel();
    }
    public void getLogin(){
        String account = iloginActivity.getAccount();
        String pwd = iloginActivity.getPwd();
        iloginModel.Login(account, pwd, new OnNetListener<LoginBean>() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                iloginActivity.show(loginBean.getMsg());
                if(loginBean.getCode().equals("0")){
                    iloginActivity.ToSend(loginBean.getData().getUid(),loginBean.getData().getUsername());
                }
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
//    public void
    public void Toregister(){
        iloginActivity.ToRegister();
    }
}
