package bwei.com.heyongwu.bean;

/**
 * author:Created by MaYue.
 */

public class LeftBean {
    private String name;
    private String cid;
    private boolean isflag;

    public LeftBean(String name, boolean isflag) {
        this.name = name;
        this.cid = cid;
        this.isflag = isflag;
    }

    public boolean isflag() {
        return isflag;
    }

    public void setIsflag(boolean isflag) {
        this.isflag = isflag;
    }

    public LeftBean(String name, String cid) {
        this.name = name;
        this.cid = cid;
    }
    public LeftBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
}
