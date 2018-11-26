package userinfo.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Simple
 * @date on 2018/11/25 19:29
 */
public class UserList {
    private ArrayList<String> nos;


    public ArrayList<String> getNos() {
        return nos;
    }

    public void setNos(ArrayList<String> nos) {
        this.nos = nos;
    }

    @Override
    public String toString() {
        return "UserList{" +
                "nos=" + nos +
                '}';
    }
}
