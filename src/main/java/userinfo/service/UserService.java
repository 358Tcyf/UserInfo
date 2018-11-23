package userinfo.service;

import org.springframework.data.domain.Page;
import userinfo.pojo.User;

import java.util.Date;
import java.util.List;

/**
 * @author Simple
 * @date on 2018/11/18 23:47
 */
public interface UserService {

    public void userSignUp(User user);

    public User findByNo(User user);

    public List<User> findAll();

    public Page<User> findByPage(int page, int limit);

    public List<User> queryMethod(User user);

    public List<User> queryBetweenDate(Date beginDate, Date endDate);

    public List<User> queryEveryThing(User user, Date beginDate, Date endDate);

    public Page<User> queryByPage(User user, int page, int limit);

    public Page<User> queryBetweenDateByPage(Date beginDate, Date endDate, int page, int limit);

    public Page<User> queryEveryThingPages(User user, Date beginDate, Date endDate, int page, int limit);

}
