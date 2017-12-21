package bwei.com.heyongwu.view.zhuye.view.fenlei;

import java.util.List;

import bwei.com.heyongwu.bean.XqBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Yw_Ambition on 2017/12/15.
 */

public class Percenter {
    private Iamin iamin;

    public Percenter(Iamin iamin) {
        this.iamin = iamin;
    }
    public void showaaa(String pscid){
        ServiceAPIS serviceAPIS = RetorfitHelper.getServerApi();
        Call<XqBean> android = serviceAPIS.bean(pscid + "");
        android.enqueue(new Callback<XqBean>() {



            @Override
            public void onResponse(Call<XqBean> call, Response<XqBean> response) {
                XqBean body = response.body();
                List<XqBean.DataBean> data = body.getData();
                iamin.showiu(data);
            }
            @Override
            public void onFailure(Call<XqBean> call, Throwable t) {

            }
        });
    }

}
