package bwei.com.heyongwu.percenter;

import java.util.List;

import bwei.com.heyongwu.bean.Catagory;
import bwei.com.heyongwu.bean.ProductCatagoryBean;
import bwei.com.heyongwu.model.ClassModel;
import bwei.com.heyongwu.model.IClassModel;
import bwei.com.heyongwu.network.OnNetListener;
import bwei.com.heyongwu.view.zhuye.view.fenlei.IPerson;


public class ClassPresenter {
    private IPerson iClassActivity;
    private IClassModel iClassModel;
    public ClassPresenter(IPerson iClassActivity){
        this.iClassActivity=iClassActivity;
        iClassModel=new ClassModel();
    }
    public void getProductCatagory(String cid){
        iClassModel.getProductCatagory(cid + "", new OnNetListener<ProductCatagoryBean>() {
            @Override
            public void onSuccess(ProductCatagoryBean productCatagoryBean) {
                iClassActivity.showElvData(productCatagoryBean.getData());
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
    //获取分类
    public void getCatagory(){
        iClassModel.getCatagory(new OnNetListener<Catagory>() {

            @Override
            public void onSuccess(final Catagory catagory) {
                iClassActivity.showData(catagory.getData());
                List<Catagory.DataBean> dataBeen=catagory.getData();
                int cid=dataBeen.get(0).getCid();
                iClassModel.getProductCatagory(cid + "", new OnNetListener<ProductCatagoryBean>() {
                    @Override
                    public void onSuccess(ProductCatagoryBean productCatagoryBean) {
                        iClassActivity.showData(catagory.getData());
                        //拿到右侧第一条数据
                        List<Catagory.DataBean> dataBean = catagory.getData();
                        int cid = dataBean.get(0).getCid();
                        //获取右侧的数据
                        getProductCatagory(cid + "");
                    }
                    @Override
                    public void onFailure(Exception e) {

                    }
                });
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
