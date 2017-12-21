package bwei.com.heyongwu.view.zhuye.view.fenlei;

import java.util.List;

import bwei.com.heyongwu.bean.Catagory;
import bwei.com.heyongwu.bean.ProductCatagoryBean;

/**
 * Created by Yw_Ambition on 2017/12/13.
 */

public interface IPerson {
     void showData(List<Catagory.DataBean> list);
     void showElvData(List<ProductCatagoryBean.DataBean> list);
}
