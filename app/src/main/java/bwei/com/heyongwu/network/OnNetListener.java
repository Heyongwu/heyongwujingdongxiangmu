package bwei.com.heyongwu.network;

/**
 * Created by Yw_Ambition on 2017/11/9.
 */

public interface OnNetListener<T> {
    void onSuccess(T t);
    void onFailure(Exception e);
}
