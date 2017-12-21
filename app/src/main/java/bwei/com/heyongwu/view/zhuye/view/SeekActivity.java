package bwei.com.heyongwu.view.zhuye.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import bwei.com.heyongwu.R;
import bwei.com.heyongwu.adapter.SouSuoHorizontalRvAdapter;
import bwei.com.heyongwu.adapter.SouSuoVerticalRvAdapter;

public class SeekActivity extends AppCompatActivity {

    @BindView(R.id.ssfinish)
    Button ssfinish;
    @BindView(R.id.ssedit)
    EditText ssedit;
    @BindView(R.id.ssbutton)
    Button ssbutton;
    @BindView(R.id.sousuohorizontalrv)
    RecyclerView sousuohorizontalrv;
    @BindView(R.id.sousuoverticalrv)
    RecyclerView sousuoverticalrv;
    private List<String> strlist = new ArrayList<>();
    private SouSuoVerticalRvAdapter souSuoVerticalRvAdapter;
    private static final String TAG = "SouSuoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek);
        ButterKnife.bind(this);
        initData();

        souSuoVerticalRvAdapter = new SouSuoVerticalRvAdapter(SeekActivity.this, strlist);

        LinearLayoutManager tManager = new LinearLayoutManager(SeekActivity.this, LinearLayoutManager.VERTICAL, true);

        sousuoverticalrv.setLayoutManager(tManager);

        sousuoverticalrv.setAdapter(souSuoVerticalRvAdapter);

    }

    private void initData() {

        List<String> horizontallist = new ArrayList<>();

        horizontallist.add("衬衣");
        horizontallist.add("韩版短裤");
        horizontallist.add("9分裤 新品");
        horizontallist.add("青年套装");
        horizontallist.add("外星人笔记本");
        horizontallist.add("小汽车");



        SouSuoHorizontalRvAdapter souSuoHorizontalRvAdapter = new SouSuoHorizontalRvAdapter(SeekActivity.this, horizontallist);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SeekActivity.this, LinearLayoutManager.HORIZONTAL, false);

        sousuohorizontalrv.setLayoutManager(linearLayoutManager);

        sousuohorizontalrv.setAdapter(souSuoHorizontalRvAdapter);
    }

    @OnClick({R.id.ssfinish, R.id.ssbutton})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ssfinish:

                finish();
                break;
            case R.id.ssbutton:

                String sseditstr = ssedit.getText().toString().trim();

                if (sseditstr != null && !sseditstr.equals("")) {
                    strlist.add(sseditstr);
                }
                souSuoVerticalRvAdapter.notifyDataSetChanged();
                if (sseditstr.equals("笔记本")){
                    Intent intent = new Intent(SeekActivity.this, Leisonye_Activity.class);
                    intent.putExtra("pscid","40");
                    startActivity(intent);
                }else if(sseditstr.equals("手机")){
                    Intent intent = new Intent(SeekActivity.this, Leisonye_Activity.class);
                    intent.putExtra("pscid","39");
                    startActivity(intent);
                }
                break;


        }
    }

    @OnClick(R.id.clearbtn)
    public void onViewClicked() {
        strlist.clear();
        souSuoVerticalRvAdapter.notifyDataSetChanged();
    }
}
