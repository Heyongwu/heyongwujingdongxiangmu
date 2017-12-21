package bwei.com.heyongwu.view.zhuye.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import bwei.com.heyongwu.R;
import bwei.com.heyongwu.adapter.NewsListAdapter;
import bwei.com.heyongwu.adapter.TuiAdapter;
import bwei.com.heyongwu.bean.Fbean;
import bwei.com.heyongwu.bean.NewsBean;
import bwei.com.heyongwu.bean.RelvBean;
import bwei.com.heyongwu.view.zhuye.percenter.INewsView;
import bwei.com.heyongwu.view.zhuye.percenter.Miaosha;
import bwei.com.heyongwu.view.zhuye.percenter.Ontext;
import bwei.com.heyongwu.view.zhuye.percenter.ShouPreaenter;
import bwei.com.heyongwu.view.zhuye.percenter.TuiView;

public class HomeFragment extends Fragment implements Ontext,INewsView,TuiView,Miaosha {
    private View view;
    private ArrayList<String> list = new ArrayList<String>();
    private Banner ban;
    private LinearLayout big_title;
    private TitleView ttt;
    private RecyclerView rv;
    ArrayList<RelvBean> list2=new ArrayList<RelvBean>();
    private NewsListAdapter adapter;
    private RecyclerView shou_xrv;
    private GridLayoutManager gridLayoutManager;
    private TuiAdapter adapter2;
    List<Tui> list3=new ArrayList<Tui>();
    private ShouPreaenter shouPreaenter;
    private String images;
    private ImageView s1img1;
    private ImageView s1img2;
    private ImageView s1img3;
    private ImageView s2img1;
    private ImageView s2img2;
    private ImageView s3img1;
    private ImageView s3img2;
    private ImageView s4img1;
    private ImageView s4img2;
    private String images2;
    private String image3;
    private String image4;
    private String image5;
    private String image6;
    private String image7;
    private String image8;
    private String image9;
    private long mHour = 02;
    private long mMin = 15;
    private long mSecond = 36;
    private boolean isRun = true;

    private Handler timeHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==1) {
                computeTime();
                if (mHour<10){
                    tv_hour.setText("0"+mHour+"");
                }else {
                    tv_hour.setText("0"+mHour+"");
                }
                if (mMin<10){
                    tv_minute.setText("0"+mMin+"");
                }else {
                    tv_minute.setText(mMin+"");
                }
                if (mSecond<10){
                    tv_second.setText("0"+mSecond+"");
                }else {
                    tv_second.setText(mSecond+"");
                }
            }
        }
    };
    private ViewFlipper homepage_notice_vf;
    private LinearLayout notice_ll;
    private ViewFlipper notice_vf;
    private LooperTextView ltv;
    private SimpleDraweeView ximg;
    private TitleView titlevv;

    private void computeTime() {
        mSecond--;
        if(mSecond<0){
            mMin--;
            mSecond=59;
            if(mMin<0){
                mMin=59;
                mHour--;
            }
        }
    }
    private void startrun(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(isRun){
                    try {
                        Thread.sleep(1000);
                        Message obtain = Message.obtain();
                        obtain.what=1;
                        timeHandler.sendMessage(obtain);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();
    }

    private TextView tv_hour;
    private TextView tv_minute;
    private TextView tv_second;
    ArrayList<String> titleList = new ArrayList<String>(); // 上下滚动消息栏内容
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home, container, false);

        ban =  view.findViewById(R.id.ban);
        ttt =  view.findViewById(R.id.titlevv);

        ImageView timg=view.findViewById(R.id.timg);
        titlevv =view.findViewById(R.id.titlevv);

        titlevv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SeekActivity.class);
                startActivity(intent);
            }
        });
        startrun();
        //秒杀
        ximg =view.findViewById(R.id.ximg);
        tv_hour =view.findViewById(R.id.tv_hour);
        tv_minute =view.findViewById(R.id.tv_minute);
        tv_second =view.findViewById(R.id.tv_second);
        s1img1 =view.findViewById(R.id.s1img1);
        s1img2 =view.findViewById(R.id.s1img2);
        s1img3 =view.findViewById(R.id.s1img3);
        s2img1 =view.findViewById(R.id.s2img1);
        s2img2 =view.findViewById(R.id.s2img2);
        s3img1 =view.findViewById(R.id.s3img1);
        s3img2 =view.findViewById(R.id.s3img2);
        s4img1 =view.findViewById(R.id.s4img1);
        s4img2 =view.findViewById(R.id.s4img2);
        //京东快报
        ltv =(LooperTextView)view.findViewById(R.id.ltv);
        ltv.setTipList(generateTips());
        //为你推荐
        shou_xrv =view.findViewById(R.id.shou_xrv);
        shouPreaenter = new ShouPreaenter(getActivity(),this,this,this,this);
        gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        shou_xrv.setLayoutManager(gridLayoutManager);

        rv =view.findViewById(R.id.rv_news);
        this.adapter = new NewsListAdapter(getActivity(),list2);
        GridLayoutManager staggered2=new GridLayoutManager(getActivity(), 2, GridLayoutManager.HORIZONTAL, false);
        rv.setLayoutManager(staggered2);
        rv.setAdapter(this.adapter);
        shouPreaenter.lun("http://120.27.23.105/ad/getAd");
        shouPreaenter.Relv("http://120.27.23.105/product/getCatagory");
        shouPreaenter.tui("http://120.27.23.105/ad/getAd");
        return view;
    }

    private List<String> generateTips() {
        List<String> tips = new ArrayList<>();
        tips.add("AI就要掌控世界了？绝对没你想得那么快！");
        tips.add("衣服大一号,人就瘦一圈?");
        tips.add("闪瞎:全球最贵五辆摩托车");
        tips.add("一半受访者会被类人机器人吓跑!");
        tips.add("深度学习索引速度更快、占用空间更少");
        tips.add("资源| 谷歌开源TFGAN：轻量级生成对抗网络工具库?");
        tips.add("谷歌团队越狱苹果系统");
        return tips;
    }
    @Override
    public void onSuccess(Object o) {

        Fbean bean = (Fbean) o;
        List<Fbean.DataBean> data = bean.getData();
        for (int i=0;i<data.size();i++){
            String icon = data.get(i).getIcon();
            list.add(icon);
        }
        ban.setImageLoader(new ImgApp());//引用ImgApp,加载里面的东西
        ban.setImages(list);
        ban.isAutoPlay(true);
        ban.setDelayTime(2000);
        ban.start();
    }

    @Override
    public void onFailed(String e) {

    }
    //Recyclerview展示
    @Override
    public void success(String tag, Object news) {
        NewsBean bean = (NewsBean) news;
        List<NewsBean.DataBean> data = bean.getData();
        for (int i=0;i<data.size();i++){
            String icon = data.get(i).getIcon();
            String name = data.get(i).getName();
            list2.add(new RelvBean(icon,name));
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void failed(String tag, String e) {

    }

    @Override
    public void Tuisuccess(String tag, Object news) {
        Fbean bean = (Fbean) news;
        List<Fbean.TuijianBean.ListBean> list = bean.getTuijian().getList();
        for (int i=0;i<list.size();i++){
            String images = list.get(i).getImages();
            String title = list.get(i).getTitle();
            double price = list.get(i).getPrice();
            int pid = list.get(i).getPid();
            list3.add(new Tui(images,title,price,pid));
        }
        adapter2 = new TuiAdapter(getActivity(),list3);
        shou_xrv.setAdapter(adapter2);
        adapter2.notifyDataSetChanged();

    }

    @Override
    public void Tuifailed(String tag, String e) {

    }

    @Override
    public void miaoSuccess(Object o) {
    }

    @Override
    public void miaoFailed(String e) {

    }
}