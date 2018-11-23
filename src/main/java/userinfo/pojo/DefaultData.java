package userinfo.pojo;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author Simple
 * @date on 2018/11/19 18:48
 */
public class DefaultData {
    int code;
    String msg;
    int count;
    Page<User> data;

    public DefaultData() {
    }

    public DefaultData(int code, String msg, int count, Page<User> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Page<User> getData() {
        return data;
    }

    public void setData(Page<User> data) {
        this.data = data;
    }
}
