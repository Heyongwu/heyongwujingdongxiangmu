package bwei.com.heyongwu.view.zhuye.view.fenlei;

import bwei.com.heyongwu.bean.XqBean;
import bwei.com.heyongwu.network.Api;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Yw_Ambition on 2017/12/15.
 */

public interface ServiceAPIS {
    @POST(Api.PPP)
    Call<XqBean> bean(@Query("pscid") String pscid);

}
