package com.len.pdms.model.vo;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

@Data
public class TenantVo implements Serializable {//实现序列化
    //id
    private String id;
    //项目名字
    private String tenantName;
    //创建用户
    private String username;
    //创建用户密码
    private String password;
    //创建时间
    private Date creatDate;
}
