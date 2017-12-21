package bwei.com.heyongwu.view.zhuye.view.setting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bwei.com.heyongwu.R;


public class MyRegisterActivity extends AppCompatActivity implements IRegisterActivity , View.OnClickListener{
    /**
     * 请输入账号
     */
    private EditText mLgEt1;
    /**
     * 请输入密码
     */
    private EditText mLgEt2;
    /**
     * 注册
     */
    private Button mLgBt;
    private RegisterPresenter registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_register);
        initView();
        registerPresenter = new RegisterPresenter(this);
    }
    private void initView() {
        mLgEt1 = (EditText) findViewById(R.id.lg_et1);
        mLgEt2 = (EditText) findViewById(R.id.lg_et2);
        mLgBt = (Button) findViewById(R.id.lg_bt);
        mLgBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.lg_bt:
                registerPresenter.register();
                break;
        }
    }

    @Override
    public String getAccount() {
        return mLgEt1.getText().toString();
    }

    @Override
    public String getPwd() {
        return mLgEt2.getText().toString();
    }

    @Override
    public void show(String str) {
        Toast.makeText(MyRegisterActivity.this,str,Toast.LENGTH_LONG).show();
    }

    @Override
    public void ToLogin() {
        Intent intent = new Intent();
        intent.setClass(MyRegisterActivity.this,MyLoginActivity.class);
        startActivity(intent);
    }
}
