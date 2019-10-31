package cn.smbms.service.role;

import cn.smbms.pojo.Role;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class RoleServiceImplTest {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    private RoleService roleService = (RoleService) ac.getBean("roleService");

    @Test
    public void getRoleList() {
        List<Role> roleList = roleService.getRoleList();
        for (Role role : roleList) {
            logger.info(role);
        }
    }
}