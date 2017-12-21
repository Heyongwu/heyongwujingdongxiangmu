package bwei.com.heyongwu.view.zhuye.model;


import java.util.List;

import bwei.com.heyongwu.bean.LeiSonYeBean;

/**
 * Created by Yw_Ambition on 2017/11/9.
 */

public interface LeiSonYeView {
    void Leisuccess(List<LeiSonYeBean.DataBean> list);
    void Leifailed(String tag, String e);
}
