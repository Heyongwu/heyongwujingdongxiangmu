package bwei.com.heyongwu.view.zhuye.model;

import bwei.com.heyongwu.bean.LunBoBean;
import bwei.com.heyongwu.network.OnNetListener;
import bwei.com.heyongwu.network.ServiceAPILun;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Yw_Ambition on 2017/12/13.
 */

public class LunBoModel implements ILunboModel{
    @Override
    public void showLunbo(final OnNetListener<LunBoBean> onNetListener) {
        ServiceAPILun serviceAPI = null;
        Flowable<LunBoBean> bean = serviceAPI.bean();
        bean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LunBoBean>() {
                    @Override
                    public void accept(LunBoBean lunBoBean) throws Exception {
                        onNetListener.onSuccess(lunBoBean);
                    }
                });
    }
}
