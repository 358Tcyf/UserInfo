package userinfo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import userinfo.pojo.User;

import java.util.Date;
import java.util.List;

/**
 * @author Simple
 * @date on 2018/11/18 23:46
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select u from User u where u.no = ?1")
    public User findByNo(String no);

    @Query(value = "select u from User u where u.no like %?1% and u.name like %?2% and u.status like %?3% and u.access like %?4%")
    public List<User> queryMethod(String no, String name, String status, String access);

    @Query(value = "select u from User u where u.no like %?1% and u.name like %?2% and u.status like %?3% and u.access like %?4% ORDER BY ?#{#pageable}")
    public Page<User> queryMethodPage(String no, String name, String status, String access, Pageable pageable);

    @Query(value = "select u from User u where u.ct between ?1 and ?2")
    public List<User> findBetweenDate(Date beginDate, Date endDate);

    @Query(value = "select u from User u where u.ct between ?1 and ?2 ORDER BY ?#{#pageable}")
    public Page<User> findBetweenDatePages(Date beginDate, Date endDate, Pageable pageable);

    @Query(value = "select u from User u where u.no like %?1% and u.name like %?2% and u.status like %?3% and u.access like %?4% and u.ct between ?5 and ?6")
    public List<User> findEveryThing(String no, String name, String status, String access, Date beginDate, Date endDate);

    @Query(value = "select u from User u where u.no like %?1% and u.name like %?2% and u.status like %?3% and u.access like %?4% and u.ct between ?5 and ?6 ORDER BY ?#{#pageable}")
    public Page<User> findEveryThingPages(String no, String name, String status, String access, Date beginDate, Date endDate, Pageable pageable);
}