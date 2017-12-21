package bwei.com.heyongwu.view.zhuye.view.fenlei;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import bwei.com.heyongwu.R;
import bwei.com.heyongwu.adapter.RecyclerViewClickListener;
import bwei.com.heyongwu.adapter.XiangqingAdapter;
import bwei.com.heyongwu.bean.XqBean;
import bwei.com.heyongwu.xiaodongxi.Titanic;
import bwei.com.heyongwu.xiaodongxi.TitanicTextView;

public class Xiangqing extends AppCompatActivity implements Iamin{
    @BindView(R.id.title3)
    Button title3;
    @BindView(R.id.psps)
    TitanicTextView psps;
    @BindView(R.id.title4)
    Button title4;
    @BindView(R.id.layout_top)
    LinearLayout layoutTop;
    @BindView(R.id.xqtv1)
    TextView xqtv1;
    @BindView(R.id.xqtv2)
    TextView xqtv2;
    @BindView(R.id.xqtv3)
    TextView xqtv3;
    @BindView(R.id.xqtv4)
    TextView xqtv4;
    @BindView(R.id.xq_rlv)
    RecyclerView xqRlv;
    private TitanicTextView psp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiangqing);
        ButterKnife.bind(this);
        psp = findViewById(R.id.psps);
        Typeface face = Typeface.createFromAsset(getAssets(), "font/english.ttf");
        psp.setTypeface(face);
        new Titanic().start(psp);


        Intent intent = getIntent();
        int pscid = intent.getIntExtra("pscid", 1);
        new Percenter(this).showaaa(pscid+"");


    }


    @Override
    public void showiu(final List<XqBean.DataBean> xiangqBeans) {


        xqRlv.setLayoutManager(new LinearLayoutManager(this));
        XiangqingAdapter xiangqingAdapter = new XiangqingAdapter(xiangqBeans, this);
        xqRlv.setAdapter(xiangqingAdapter);
        xqRlv.addOnItemTouchListener(new RecyclerViewClickListener(this,new RecyclerViewClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                XqBean.DataBean dataBean = xiangqBeans.get(position);
                int pid = dataBean.getPid();
                Intent intent = new Intent(Xiangqing.this, JrgwcActivity.class);
                intent.putExtra("pid",pid);
                startActivity(intent);
            }
            @Override
            public void onItemLongClick(View view, int position) {

            }
        }));
    }
}
