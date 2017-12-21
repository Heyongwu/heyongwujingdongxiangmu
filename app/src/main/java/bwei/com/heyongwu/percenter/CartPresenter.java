package bwei.com.heyongwu.percenter;


import java.util.ArrayList;
import java.util.List;

import bwei.com.heyongwu.bean.GoodBean;
import bwei.com.heyongwu.model.CartModel;
import bwei.com.heyongwu.network.OnNetListener;
import bwei.com.heyongwu.view.zhuye.view.gouwuche.IcartView;

/**
 * Created by DangByMySide on 2017/12/7.
 */

public class CartPresenter {
    private IcartView icartView;
    private CartModel cartModel;

    public CartPresenter(IcartView icartView) {
        this.icartView = icartView;
        cartModel=new CartModel();
    }
    public void getGoods(String uid){
        cartModel.getGoods(uid, new OnNetListener<GoodBean>() {
            @Override
            public void onSuccess(GoodBean goodBean) {
                List<GoodBean.DataBean> dataBean = goodBean.getData();
                List<List<GoodBean.DataBean.DatasBean>> childList=new ArrayList<List<GoodBean.DataBean.DatasBean>>();
                for (int i = 0; i < dataBean.size(); i++) {
                    List<GoodBean.DataBean.DatasBean> datas=dataBean.get(i).getDatas();
                    childList.add(datas);
                }
                icartView.showList(dataBean,childList);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });

    }
}

//.getGoods(new OnNetListener<GoodBean>() {
//@Override
//public void onSuccess(GoodBean goodBean) {
//        List<GoodBean.DataBean> dataBean = goodBean.getData();
//        List<List<GoodBean.DataBean.DatasBean>> childList=new ArrayList<List<GoodBean.DataBean.DatasBean>>();
//        for (int i = 0; i < dataBean.size(); i++) {
//        List<GoodBean.DataBean.DatasBean> datas=dataBean.get(i).getDatas();
//        childList.add(datas);
//        }
//        icartView.showList(dataBean,childList);
//        }
//
//@Override
//public void onFailure(Exception e) {
//
//        }
//        });