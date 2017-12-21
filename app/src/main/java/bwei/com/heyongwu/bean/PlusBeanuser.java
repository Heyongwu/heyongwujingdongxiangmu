package bwei.com.heyongwu.bean;

/**
 * Created by Yw_Ambition on 2017/11/9.
 */
public class PlusBeanuser {
    public String name;

    public PlusBeanuser(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PlusBeanuser{" +
                "name='" + name + '\'' +
                '}';
    }
}
