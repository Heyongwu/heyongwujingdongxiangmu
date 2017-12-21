package bwei.com.heyongwu.model;


import java.util.List;
import java.util.Map;

import bwei.com.heyongwu.bean.My_ListBean;
import bwei.com.heyongwu.bean.My_RetBean;
import bwei.com.heyongwu.bean.My_VideoBean;
import bwei.com.heyongwu.network.RetrofitUtils;
import bwei.com.heyongwu.percenter.VidoPresenter;
import io.reactivex.Flowable;

/**
 * Created by Yw_Ambition on 2017/11/9.
 */

public class Models implements ModelPost {
    private VidoPresenter vidoPresenter;
    public Models(VidoPresenter vidoPresenter) {
        this.vidoPresenter = vidoPresenter;
    }
    @Override
    public void getData(Map<String, String> map) {
        Flowable<My_VideoBean<My_RetBean<List<My_ListBean>>>> flowable = RetrofitUtils.getInstance().getApiservise().getVideo(map);
        vidoPresenter.get(flowable);
    }

}
