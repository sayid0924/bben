package com.bben.service;

import com.bben.entity.User;
import com.github.pagehelper.Page;


public interface UserService {

    /**
     * 分页查询
     * @param pageNo 页号
     * @param pageSize 每页显示记录数
     * @return
     *
     */

    Page<User> findByPage(int pageNo, int pageSize);

}
