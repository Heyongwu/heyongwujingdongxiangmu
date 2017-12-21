package bwei.com.heyongwu;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;



public class HandleActicity extends AppCompatActivity {
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_handle_acticity);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent();
                intent.setClass(HandleActicity.this,MainActivity.class);

                startActivity(intent);

            }
        },3000);


    }


}
