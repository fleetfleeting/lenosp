package com.len.pdms.service.provider.impl;



import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import com.google.common.collect.Maps;
import com.len.base.BaseMapper;
import com.len.base.impl.BaseServiceImpl;
import com.len.pdms.model.entity.Tenant;
import com.len.pdms.model.entity.TenantUser;
import com.len.pdms.model.vo.TenantVo;
import com.len.pdms.service.TenantService;
import com.len.pdms.service.provider.mapper.SysMapper;
import com.len.pdms.service.provider.mapper.TenantMapper;
import com.len.pdms.service.provider.mapper.TenantUserMapper;
import com.len.util.BeanUtil;


import com.len.util.IDUtil;
import com.len.util.Md5Util;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.HashMap;
import java.util.Map;

@Service
public class TenantServiceImpl extends BaseServiceImpl<Tenant,String> implements TenantService {
    @Autowired
    TenantMapper tenantMapper;
    @Autowired
    SysMapper sysMapper;
    @Autowired
    TenantUserMapper tenantUserMapper;

    @Override
    public BaseMapper<Tenant, String> getMappser() {
        return tenantMapper;
    }

    @Override
    public int addTenant(TenantVo tenantVo) {
        //添加租户
        Tenant tenant=new Tenant();
        BeanUtil.copyNotNullBean(tenantVo,tenant);
        //解决创建时间和uuid问题
        java.util.Date date=new java.util.Date();
        java.sql.Date sqlDate=new java.sql.Date(date.getTime());
        tenant.setCreatDate(sqlDate);
        //tenant.setId();
        tenant.setId(IDUtil.genId());
        int status=this.insertSelective(tenant);
        //*****************************************************************************
        //添加一条用户的信息
        //*******************************************************************************
        Map map= Maps.newHashMap();
        map.put("id",tenant.getId());
        map.put("username",tenantVo.getUsername());
        map.put("password",Md5Util.getMD5(tenantVo.getPassword().trim(),tenantVo.getUsername().trim()));
        map.put("create_date",tenant.getCreatDate());
        sysMapper.insertUser(map);
        //************************************************************************************
        //租户用户信息
        //************************************************************************************
        TenantUser tenantUser=new TenantUser();
        tenantUser.setId(IDUtil.genId());
        tenantUser.setTenantId(tenant.getId());
        tenantUser.setUserId(tenant.getId());
        tenantUser.setIsAdmin(1);//这里的1表示他是管理员
        tenantUser.setCreateDate(sqlDate);
        tenantUserMapper.insert(tenantUser);
        //************************************************************************************
        //租户用户角色信息
        //************************************************************************************
        Map ur=new HashMap();
        ur.put("user_id",tenant.getId());
        //默认租户角色信息,可以再数据库中查看
        ur.put("role_id","f40b1dcd1f93462e94fe03aa15878b44");
        sysMapper.insertUserRole(ur);

        return status;
    }

    @Override
    public int addRenantUser(String userName, String tenantId) {
        return 0;
    }
}
