package bwei.com.heyongwu.bean;

/**
 * Created by 何永武 on 2017/11/15.
 */

public class LoginBean {

    /**
     * msg : 登录成功
     * code : 0
     * data : {"age":null,"appkey":"9959e4af8ff46156","appsecret":"3FE94D81BDFEF63567737D3A502829A2","createtime":"2017-11-15T13:16:33","email":null,"gender":null,"icon":null,"mobile":"13366645979","money":null,"nickname":null,"password":"8F669074CAF5513351A2DE5CC22AC04C","token":"32646230799DDF1FE418E7A4A91BEAF4","uid":1477,"username":"13366645979"}
     */

    private String msg;
    private String code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * age : null
         * appkey : 9959e4af8ff46156
         * appsecret : 3FE94D81BDFEF63567737D3A502829A2
         * createtime : 2017-11-15T13:16:33
         * email : null
         * gender : null
         * icon : null
         * mobile : 13366645979
         * money : null
         * nickname : null
         * password : 8F669074CAF5513351A2DE5CC22AC04C
         * token : 32646230799DDF1FE418E7A4A91BEAF4
         * uid : 1477
         * username : 13366645979
         */

        private Object age;
        private String appkey;
        private String appsecret;
        private String createtime;
        private Object email;
        private Object gender;
        private Object icon;
        private String mobile;
        private Object money;
        private Object nickname;
        private String password;
        private String token;
        private int uid;
        private String username;

        public Object getAge() {
            return age;
        }

        public void setAge(Object age) {
            this.age = age;
        }

        public String getAppkey() {
            return appkey;
        }

        public void setAppkey(String appkey) {
            this.appkey = appkey;
        }

        public String getAppsecret() {
            return appsecret;
        }

        public void setAppsecret(String appsecret) {
            this.appsecret = appsecret;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public Object getGender() {
            return gender;
        }

        public void setGender(Object gender) {
            this.gender = gender;
        }

        public Object getIcon() {
            return icon;
        }

        public void setIcon(Object icon) {
            this.icon = icon;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Object getMoney() {
            return money;
        }

        public void setMoney(Object money) {
            this.money = money;
        }

        public Object getNickname() {
            return nickname;
        }

        public void setNickname(Object nickname) {
            this.nickname = nickname;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
