package com.bben.apidoc.bean;

import com.apidoc.bean.ApiDocParam;

import java.util.List;

/**
 * @Description: 响应参数
 * @Author: admin
 * @CreateDate: 2018/1/7 11:38
 */
public class ApiDocRespParams {

    private String description;

    private List<com.apidoc.bean.ApiDocParam> params;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<com.apidoc.bean.ApiDocParam> getParams() {
        return params;
    }

    public void setParams(List<ApiDocParam> params) {
        this.params = params;
    }

}
