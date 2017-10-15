package cn.sdn.entity;

import org.apache.cxf.common.security.UsernameToken;

/**
 * Created by L on 2017/10/15.
 */
public class User {
    /**
     * id
     */
    private Integer id;
    /**
     * userName
     */
    private String userName;
    /**
     * password
     */
    private String password;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
