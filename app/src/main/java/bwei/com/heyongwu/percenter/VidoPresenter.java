package bwei.com.heyongwu.percenter;

import java.util.List;
import java.util.Map;

import bwei.com.heyongwu.bean.My_ListBean;
import bwei.com.heyongwu.bean.My_RetBean;
import bwei.com.heyongwu.bean.My_VideoBean;
import bwei.com.heyongwu.model.Models;
import bwei.com.heyongwu.view.zhuye.view.faxian.Iview;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by Yw_Ambition on 2017/11/9.
 */
public class VidoPresenter implements PresenterPost {
    private Iview iview;
    private DisposableSubscriber<My_VideoBean<My_RetBean<List<My_ListBean>>>> subscriber;

    public VidoPresenter(Iview iview) {
        this.iview = iview;
    }
    public void detachView() {
        if (iview != null) {
            iview = null;
        }
    }
    @Override
    public void getData(Map<String, String> map) {
        Models model = new Models(this);
        model.getData(map);
    }

    public void get(Flowable<My_VideoBean<My_RetBean<List<My_ListBean>>>> flowable){
        subscriber = flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<My_VideoBean<My_RetBean<List<My_ListBean>>>>() {
                    @Override
                    public void onNext(My_VideoBean<My_RetBean<List<My_ListBean>>> retBeanVideoBean) {
                        List<My_ListBean> list = retBeanVideoBean.getRet().getList();
                        iview.onSuccess(list);
                    }

                    @Override
                    public void onError(Throwable t) {
                        iview.onFailed(new Exception(t));
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
