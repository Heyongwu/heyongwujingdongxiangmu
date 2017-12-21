package bwei.com.heyongwu.adapter;

/**
 * Created by Yw_Ambition on 2017/12/16.
 */

class ItemData {
    private String imgResId;
    private String title;

    public String getImgResId() {
        return imgResId;
    }

    public void setImgResId(String imgResId) {
        this.imgResId = imgResId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ItemData(String imgResId, String title) {
        this.imgResId = imgResId;
        this.title = title;
    }
}
