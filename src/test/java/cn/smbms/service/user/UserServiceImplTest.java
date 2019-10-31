package cn.smbms.service.user;

import cn.smbms.pojo.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class UserServiceImplTest {
private ApplicationContext ac = new  ClassPathXmlApplicationContext("applicationContext.xml");
private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
private UserService userService = (UserService) ac.getBean("userService");
    @Test
    public void add() {
        User user = new User();
        user.setUserName("张三");
        user.setUserPassword("111");
        user.setUserCode("123");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1995,3,6);
        Date date = calendar.getTime();
        user.setBirthday(date);
        user.setCreatedBy(1);
        user.setCreationDate(new Date());
        user.setUserRole(1);
        boolean add = userService.add(user);
        logger.info(add);
    }

    @Test
    public void login() {
        User login = userService.login("123", "111");
        logger.info(login);
    }

    @Test
    public void getUserList() {
        List<User> userList = userService.getUserList("", 1, 1, 5);
        for (User user : userList) {
            logger.info(user);
        }
    }

    @Test
    public void getUserCount() {
        int count = userService.getUserCount("", 1);
        logger.info(count);
    }

    @Test
    public void selectUserCodeExist() {
        User user = userService.selectUserCodeExist("123");
        logger.info(user);
    }

    @Test
    public void deleteUserById() {
        boolean b = userService.deleteUserById(21);
        logger.info(b);
    }

    @Test
    public void getUserById() {
        User user = userService.getUserById(22);
        logger.info(user);
    }

    @Test
    public void modify() {
        User user = userService.getUserById(21);
        user.setUserPassword("111");
        user.setPhone("15555555555555");
        user.setGender(1);
        boolean modify = userService.modify(user);
        logger.info(modify);
    }

    @Test
    public void updatePwd() {
        boolean pwd = userService.updatePwd(22, "888");
        logger.info(pwd);
    }
}