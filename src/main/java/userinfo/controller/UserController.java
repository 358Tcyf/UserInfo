package userinfo.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import userinfo.pojo.DefaultData;
import userinfo.pojo.User;
import userinfo.service.impl.UserServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author Simple
 * @date on 2018/11/18 3:13
 */
@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "insertUser", method = {RequestMethod.POST}, produces = "text/html;charset=utf-8")
    @ResponseBody
    public String insertUser(User user) {
        userService.userSignUp(user);
        String json = JSON.toJSONString(user);
        System.out.println(json);
        return json;
    }

    @RequestMapping(value = "insertOne", produces = "text/html;charset=utf-8")
    public String insertOne() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        String dateNowStr = sdf.format(date);
        User userOne = new User();
        long min = 20153399960000L;
        long max = 20153399969999L;
        long rangeLong = min + (((long) (new Random().nextDouble() * (max - min))));
        String noString = String.valueOf(rangeLong);
        userOne.setNo(noString);
        userOne.setName("王二");
        userOne.setCollage("计算机工程学院");
        userOne.setBranch("计算机系");
        userOne.setMajor("计算机科学与技术");
        userOne.setAccess("PC端");
        userOne.setPassword("123456");
        userOne.setStatus("启用");
        userOne.setCt(date);
        userOne.setCtStr(dateNowStr);
        userOne.setUt(date);
        userOne.setUtStr(dateNowStr);
        userService.userSignUp(userOne);
        String str = JSON.toJSONString(userOne);
        System.out.println(str);
        return str;
    }

    @RequestMapping(value = "checkPsd", method = {RequestMethod.POST}, produces = "text/html;charset=utf-8")
    @ResponseBody
    public String checkPsd(User user) {
        String json = JSON.toJSONString(user);
        User checkUser = userService.findByNo(user);
        System.out.println(checkUser);
        if (user.getPassword().equals(checkUser.getPassword())) {
            return json;
        } else {
            return null;
        }
    }

    @RequestMapping(value = "allUser")
    public String allUser() {

        List<User> users = userService.findAll();
        String str = JSON.toJSONString(users); // List转json
        return str;
    }

    @RequestMapping(value = "allUserTable", produces = "text/html;charset=utf-8")
    public String userTable(int page, int limit) {
        Page<User> users = userService.findByPage(page, limit);
        int count = userService.findAll().size();
        DefaultData data = new DefaultData(200, "", count, users);
        String str = JSON.toJSONString(data);
//        System.out.println(str);
        return str;
    }


    @RequestMapping(value = "queryUser", method = {RequestMethod.POST}, produces = "text/html;charset=utf-8")
    @ResponseBody
    public String queryMethod(User user) {
        String json = JSON.toJSONString(user);
        System.out.println(json);
        List<User> queryUser = userService.queryMethod(user);
        String str = JSON.toJSONString(queryUser); // List转json
        System.out.println(str);
        return str;
    }

    @RequestMapping(value = "queryUserTable", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String queryTableTest(String no, String name,
                                 String status, String access,
                                 String beginDate, String endDate,
                                 int page, int limit) throws ParseException {
        Page<User> users;
        int count;
        User user = new User();
        user.setNo(no);
        user.setName(name);
        user.setStatus(status);
        user.setAccess(access);

        if (!beginDate.equals("") && !endDate.equals("")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date bDate = sdf.parse(beginDate);
            Date eDate = sdf.parse(endDate);
            Calendar c = Calendar.getInstance();
            c.setTime(eDate);
            c.add(Calendar.DAY_OF_MONTH, 1);            //利用Calendar 实现 Date日期+1天
            eDate = c.getTime();
            users = userService.queryEveryThingPages(user, bDate, eDate, page, limit);
            count = userService.queryEveryThing(user, bDate, eDate).size();
        } else {
            users = userService.queryByPage(user, page, limit);
            count = userService.queryMethod(user).size();
        }


        DefaultData data = new DefaultData(200, "", count, users);
        String str = JSON.toJSONString(data);
        return str;
    }

}
