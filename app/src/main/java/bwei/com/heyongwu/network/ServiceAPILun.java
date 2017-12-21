package bwei.com.heyongwu.network;

import bwei.com.heyongwu.bean.LunBoBean;
import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by Yw_Ambition on 2017/12/13.
 */

public interface ServiceAPILun {
    @GET(Api.LUNBO)
    public Flowable<LunBoBean> bean();
}
