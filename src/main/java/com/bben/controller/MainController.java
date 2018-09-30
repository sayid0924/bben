package com.bben.controller;


import com.alibaba.fastjson.JSONException;
import com.apidoc.annotation.*;
import com.apidoc.enumeration.DataType;
import com.apidoc.enumeration.Method;
import com.apidoc.enumeration.ParamType;
import com.bben.entity.BaseResult;
import com.bben.entity.PageInfo;
import com.bben.entity.User;
import com.bben.mapper.UserMapper1;

import com.alibaba.fastjson.JSONObject;
import com.bben.req.ReqPageInfo;
import com.bben.service.UserService;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api(name = "用户管理", order = 1)
@RestController
public class MainController {

    private Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private UserMapper1 userMapper1;

    @Autowired
    private UserService personService;

    @ApiAction(name = "查询所有数据", mapping = "all", method = Method.GET)

    @ApiRespParams({
            @ApiParam(name = "code", dataType = DataType.NUMBER, defaultValue = "0", description = "状态编码"),
            @ApiParam(name = "message", dataType = DataType.STRING, defaultValue = "操作成功", description = "提示信息"),
            @ApiParam(name = "datas", dataType = DataType.OBJECT, defaultValue = "null", description = "响应数据", object = "user"),
            @ApiParam(name = "id", dataType = DataType.NUMBER,description = "ID",belongTo = "user"),
            @ApiParam(name = "name", dataType = DataType.STRING,description = "姓名",belongTo = "user")
    })

    @RequestMapping("/all")

    public JSONObject findAll() {

        List<User> users = userMapper1.findAll();
        BaseResult.success(users);
        JSONObject json = new JSONObject();
        json.put("datas", BaseResult.success(users));
        return json;

    }

    @ApiAction(name = "查询分页数据", mapping = "page", method = Method.GET)
    @ApiReqParams(type = ParamType.JSON, value = {@ApiParam(value = ReqPageInfo.class)})
    @ApiRespParams({
            @ApiParam(name = "code", dataType = DataType.NUMBER, defaultValue = "0", description = "状态编码"),
            @ApiParam(name = "message", dataType = DataType.STRING, defaultValue = "操作成功", description = "提示信息"),
            @ApiParam(name = "datas", dataType = DataType.OBJECT, defaultValue = "null", description = "响应数据", object = "user"),
            @ApiParam(name = "id", dataType = DataType.NUMBER,description = "ID",belongTo = "user"),
            @ApiParam(name = "name", dataType = DataType.STRING,description = "姓名",belongTo = "user")
    })

    @RequestMapping("/page")
    public JSONObject findPage(ReqPageInfo pageInfo) {

        Page<User> users = personService.findByPage(pageInfo.getStart(), pageInfo.getEnd());
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<User> page = new PageInfo<>(users);
        JSONObject json = new JSONObject();
        json.put("datas", BaseResult.success(page));
        return json;

    }

    @RequestMapping("/find")
    public JSONObject findOne(Integer id) {
        User user = userMapper1.findOne(id);
        JSONObject json = new JSONObject();
        try {
            json.put("data", user);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;

    }

    @RequestMapping("/add")
    public JSONObject addOne(User user) {
        userMapper1.addOne(user);
        JSONObject json = new JSONObject();
        try {
            json.put("data", user);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;

    }

    @RequestMapping("/update")
    public JSONObject updateOne(User user) {
        userMapper1.updateOne(user);
        JSONObject json = new JSONObject();
        try {
            json.put("data", user);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

    @RequestMapping("/del")
    public void delOne(Integer id) {
        userMapper1.delOne(id);
    }

}
