package com.bben.service.impl;

import com.bben.entity.User;
import com.bben.mapper.UserMapper1;
import com.bben.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper1 userMapper1;

    @Override
    public Page<User> findByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return userMapper1.findByPage();
    }

}
