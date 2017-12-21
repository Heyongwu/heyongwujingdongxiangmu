package bwei.com.heyongwu.view.zhuye.percenter;

/**
 * Created by Yw_Ambition on 2017/11/9.
 */
public interface INewsView {
    void success(String tag, Object news);
    void failed(String tag, String e);
}
