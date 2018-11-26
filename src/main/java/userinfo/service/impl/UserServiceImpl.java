package userinfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import userinfo.dao.UserRepository;
import userinfo.pojo.User;
import userinfo.service.UserService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Simple
 * @date on 2018/11/18 23:47
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    public void userSignUp(User user) {
        repository.save(user);
    }

    public User findByNo(User user) {
        return repository.findByNo(user.getNo());
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public Page<User> findByPage(int page, int limit) {
        Pageable pageable = new PageRequest(page - 1, limit);
        return repository.findAll(pageable);
    }

    public List<User> queryMethod(User user) {
        String no = user.getNo();
        String name = user.getName();
        String status = user.getStatus();
        String access = user.getAccess();
        return repository.queryMethod(no, name, status, access);
    }

    public List<User> queryBetweenDate(Date beginDate, Date endDate) {
        return repository.findBetweenDate(beginDate, endDate);
    }

    public List<User> queryEveryThing(User user, Date beginDate, Date endDate) {
        String no = user.getNo();
        String name = user.getName();
        String status = user.getStatus();
        String access = user.getAccess();
        return repository.findEveryThing(no, name, status, access, beginDate, endDate);

    }


    public Page<User> queryByPage(User user, int page, int limit) {
        Pageable pageable = new PageRequest(page - 1, limit);
        String no = user.getNo();
        String name = user.getName();
        String status = user.getStatus();
        String access = user.getAccess();
        return repository.queryMethodPage(no, name, status, access, pageable);
    }

    public Page<User> queryBetweenDateByPage(Date beginDate, Date endDate, int page, int limit) {
        Pageable pageable = new PageRequest(page - 1, limit);
        return repository.findBetweenDatePages(beginDate, endDate, pageable);
    }

    public Page<User> queryEveryThingPages(User user, Date beginDate, Date endDate, int page, int limit) {
        Pageable pageable = new PageRequest(page - 1, limit);
        String no = user.getNo();
        String name = user.getName();
        String status = user.getStatus();
        String access = user.getAccess();
        return repository.findEveryThingPages(no, name, status, access, beginDate, endDate, pageable);
    }

    public List<User> resetPsd(List<User> users) {
        List<User> userList = new ArrayList<User>();
        for (User u : users) {
            repository.updatePsd("12345", u.getNo());
            userList.add(repository.findByNo(u.getNo()));
        }
        return userList;
    }

}
