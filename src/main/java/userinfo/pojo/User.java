package userinfo.pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Simple
 * @date on 2018/11/18 3:06
 */

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String no;
    private String name;
    private String collage;
    private String branch;
    private String major;
    private String access;
    private String password;
    private Date ct;
    private Date ut;
    private String ctStr;
    private String utStr;
    private String status;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollage() {
        return collage;
    }

    public void setCollage(String collage) {
        this.collage = collage;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCt() {
        return ct;
    }

    public void setCt(Date ct) {
        this.ct = ct;
    }

    public Date getUt() {
        return ut;
    }

    public void setUt(Date ut) {
        this.ut = ut;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public String getCtStr() {
        return ctStr;
    }

    public void setCtStr(String ctStr) {
        this.ctStr = ctStr;
    }

    public String getUtStr() {
        return utStr;
    }

    public void setUtStr(String utStr) {
        this.utStr = utStr;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", collage='" + collage + '\'' +
                ", branch='" + branch + '\'' +
                ", major='" + major + '\'' +
                ", access='" + access + '\'' +
                ", password='" + password + '\'' +
                ", ct=" + ct +
                ", ut=" + ut +
                ", ctStr='" + ctStr + '\'' +
                ", utStr='" + utStr + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
