package cn.evilcoder.model;

import java.util.Date;

/**
 * Created by huangshanqi on 2016/12/25.
 */
public class User {

    private long id;
    private String username;
    private String email;
    private String password;
    private String salt;
    private Date lastLoginTime;
    private Date ctime;
    private Date utime;

    public User() {
    }

    public User(long id, String username, String email, String password, String salt, Date lastLoginTime, Date ctime,
                Date utime) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.salt = salt;
        this.lastLoginTime = lastLoginTime;
        this.ctime = ctime;
        this.utime = utime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }
}
