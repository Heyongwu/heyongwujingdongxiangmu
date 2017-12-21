package bwei.com.heyongwu.bean;

/**
 * author:Created by MaYue.
 */

public class ChildBean {
    private String name;
    private String imgurl;
    private String pid ;
    private boolean isflag;
    private double price;
    private int num;

    public ChildBean(String name, String imgurl, String pid, double price, boolean isflag, int num) {
        this.name = name;
        this.imgurl = imgurl;
        this.pid = pid;
        this.isflag = isflag;
        this.price = price;
        this.num=num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isflag() {
        return isflag;
    }

    public void setIsflag(boolean isflag) {
        this.isflag = isflag;
    }

    public ChildBean(String name, String imgurl, String pid) {
        this.name = name;
        this.imgurl = imgurl;
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
