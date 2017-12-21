package bwei.com.heyongwu.view.zhuye.view.fenlei;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import bwei.com.heyongwu.R;
import bwei.com.heyongwu.bean.AddBean;
import bwei.com.heyongwu.bean.ShowBean;
import bwei.com.heyongwu.percenter.GetUser;
import bwei.com.heyongwu.percenter.JrGwcPrecenter;
import bwei.com.heyongwu.view.zhuye.view.ImgApp2;
import bwei.com.heyongwu.view.zhuye.view.setting.MyLoginActivity;

public class JrgwcActivity extends AppCompatActivity implements GetUser {
    private ImageView img;
    private TextView tit;
    private TextView price;
    private Button button;
    private JrGwcPrecenter presenter;

    private Map<String, String> map;
    private int pid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jrgwc);

        img =  findViewById(R.id.show_img);
        tit =  findViewById(R.id.show_tit);
        price =  findViewById(R.id.show_price);
        button =  findViewById(R.id.show_addbtn);
        button.setBackgroundColor(Color.RED);
//        Intent intent = getIntent();
//
//        pid = intent.getStringExtra("pid").toString().trim();

        Intent intent = getIntent();
        pid = intent.getIntExtra("pid", 1);

        JrGwcPrecenter p=new JrGwcPrecenter(this);
        Map<String,String> map= new HashMap<>();

        map.put("pid", pid +"");
        if(pid +""!=null){
            p.getshow("http://120.27.23.105/product/getProductDetail?source=android",map, ShowBean.class,"1");
        }
        //加入购物车点击事件
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //判断是否登录
                if(ImgApp2.sp.getBoolean("isLogin",false)){
                    int uid = ImgApp2.sp.getInt("uid", 0);
                    presenter = new JrGwcPrecenter(JrgwcActivity.this);
                    Map<String,String> map1=new HashMap<String,String>();
                    map1.put("uid",uid+"");
                    map1.put("pid", pid+"");
                    presenter.getshow("http://120.27.23.105/product/addCart?source=android",map1,AddBean.class,"2");
                    Toast.makeText(JrgwcActivity.this,"加购成功",Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(JrgwcActivity.this,"请登录!",Toast.LENGTH_SHORT).show();
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            Intent intent1 = new Intent(JrgwcActivity.this, MyLoginActivity.class);
                            startActivity(intent1);
                        }
                    },2000);

                }
            }
        });
    }
    @Override
    public void getbean(Object o, String tag) {
        if (tag.equals("1")) {
            ShowBean bean = (ShowBean) o;
            ShowBean.DataBean data = bean.getData();
            String s = data.getImages();
            String[] strings = s.split("!");

            tit.setText(data.getTitle());
            price.setText("¥ "+data.getPrice());
            price.setTextColor(Color.RED);
            Glide.with(this).load(strings[0]).into(img);
        }else if(tag.equals("2")){
            AddBean bean = (AddBean) o;
            Toast.makeText(this,bean.getMsg(),Toast.LENGTH_SHORT).show();

        }
    }
}
