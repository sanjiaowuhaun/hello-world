package cn.smbms.service.user;


import cn.smbms.dao.user.UserMapper;
import cn.smbms.pojo.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean add(User user) {
        int updateRows = userMapper.addUser(user);
        boolean flag = updateRows > 0;
        if (!flag) {
            logger.info("add failed!");
        } else {
            logger.info("add success!");
        }
        return flag;
    }

    @Override
    public User login(String userCode, String userPassword) {
        User user = userMapper.getLoginUser(userCode);
        if (user != null) {
            if (!user.getUserPassword().equals(userPassword)) {
                user = null;
            }
        }
        return user;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize) {
        logger.info("queryUserName ---- > " + queryUserName);
        logger.info("queryUserRole ---- > " + queryUserRole);
        logger.info("currentPageNo ---- > " + currentPageNo);
        logger.info("pageSize ---- > " + pageSize);
        currentPageNo = (currentPageNo-1)*pageSize;
        return userMapper.getUserList(queryUserName, queryUserRole, currentPageNo, pageSize);
    }

    @Transactional(readOnly = true)
    @Override
    public int getUserCount(String queryUserName, int queryUserRole) {
        logger.info("queryUserName ---- > " + queryUserName);
        logger.info("queryUserRole ---- > " + queryUserRole);
        return userMapper.getUserCount(queryUserName, queryUserRole);
    }
	@Transactional(readOnly = true)
    @Override
    public User selectUserCodeExist(String userCode) {
		return userMapper.getLoginUser(userCode);
    }

    @Override
    public boolean deleteUserById(Integer delId) {
		return userMapper.deleteUserById(delId) > 0;
    }
	@Transactional(readOnly = true)
    @Override
    public User getUserById(int id) {
		return userMapper.getUserById(id);
    }

    @Override
    public boolean modify(User user) {
		return userMapper.modify(user) > 0;
    }

    @Override
    public boolean updatePwd(int id, String pwd) {
		return userMapper.updatePwd(id, pwd) > 0;
    }
}
