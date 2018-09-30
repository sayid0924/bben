package com.bben.mapper;


import com.bben.entity.User;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Mapper
public interface UserMapper1 {
    List<User> findAll();

    User findOne(Integer id);

    void addOne(User user);

    void updateOne(User user);

    void delOne(Integer id);

    /**
     * 分页查询数据
     * @return
     */
    Page<User> findByPage();

}
