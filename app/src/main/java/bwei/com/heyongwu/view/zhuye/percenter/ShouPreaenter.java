package bwei.com.heyongwu.view.zhuye.percenter;

import android.content.Context;

import bwei.com.heyongwu.bean.Fbean;
import bwei.com.heyongwu.bean.NewsBean;
import bwei.com.heyongwu.network.AllBack;
import bwei.com.heyongwu.network.OkHttp;

/**
 * Created by Yw_Ambition on 2017/11/19.
 */

public class ShouPreaenter {
    private Context context;
    private Ontext ontext;
    private INewsView iNewsView;
    private TuiView tuiView;
    private Miaosha miaosha;


    public ShouPreaenter(Context context, Ontext ontext,INewsView iNewsView,TuiView tuiView,Miaosha miaosha) {
        this.context = context;
        this.ontext = ontext;
        this.iNewsView = iNewsView;
        this.tuiView=tuiView;
        this.miaosha=miaosha;
    }

    public void lun(String url){
         OkHttp.getinstance().getData(url, new AllBack() {
             @Override
             public void onSuccess(String tag,Object o) {
                   ontext.onSuccess(o);
             }

             @Override
             public void onFailed(String tag,String e) {
                 ontext.onFailed(e);
             }
         },Fbean.class,"");
     }
     public void Relv(String url) {
         OkHttp.getinstance().getData(url, new AllBack() {
             @Override
             public void onSuccess(String tag, Object o) {
                 iNewsView.success(tag, o);
             }
             @Override
             public void onFailed(String tag, String e) {
                 iNewsView.failed(tag, e);
             }
         }, NewsBean.class, "news");
     }
    //为你推荐
    public void tui(String url){
        OkHttp.getinstance().getData(url, new AllBack() {
            @Override
            public void onSuccess(String tag, Object o) {
                tuiView.Tuisuccess(tag, o);
            }

            @Override
            public void onFailed(String tag, String e) {
                tuiView.Tuifailed(tag, e);
            }
        },Fbean.class,"");
    }

    //秒杀
    public void miaosha(String url){
        OkHttp.getinstance().getData(url, new AllBack() {
            @Override
            public void onSuccess(String tag, Object o) {
                miaosha.miaoSuccess(o);
            }

            @Override
            public void onFailed(String tag, String e) {
                miaosha.miaoFailed(e);
            }
        },Fbean.class,"");
    }



}
