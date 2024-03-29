package com.nowcoder.service;

import com.nowcoder.dao.UserDao;
import com.nowcoder.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2019/7/15.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User getUser(int id){
        return userDao.selectById(id);
    }
}
