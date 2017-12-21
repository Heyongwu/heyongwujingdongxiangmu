package bwei.com.heyongwu.percenter;

import java.util.Map;

import bwei.com.heyongwu.network.AllBack;
import bwei.com.heyongwu.network.OkHttp;

/**
 * Created by Yw_Ambition on 2017/12/18.
 */

public class JrGwcPrecenter {
    private GetUser getUser;

    public JrGwcPrecenter(GetUser getUser) {
        this.getUser = getUser;
    }

    public void getshow(String url, Map<String,String> map, Class c, final String tag) {
        OkHttp.getinstance().postData(url, map, new AllBack() {
            @Override
            public void onSuccess(String tag, Object o) {
                getUser.getbean(o,tag);
            }

            @Override
            public void onFailed(String tag, String e) {

            }
        }, c, tag);
    }

}
