package bwei.com.heyongwu.view.zhuye.view.gouwuche;


import java.util.List;

import bwei.com.heyongwu.bean.GoodBean;

/**
 * Created by DangByMySide on 2017/12/7.
 */

public interface IcartView {
    public void showList(List<GoodBean.DataBean> groupList, List<List<GoodBean.DataBean.DatasBean>> childList);
}
