package bwei.com.heyongwu.network;

/**
 * Created by Yw_Ambition on 2017/11/9.
 */

public interface AllBack {
    void onSuccess(String tag, Object o);
    void onFailed(String tag, String e);
}
