package com.len.pdms.service.provider.impl;



import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import com.len.base.BaseMapper;
import com.len.base.impl.BaseServiceImpl;
import com.len.pdms.model.entity.Tenant;
import com.len.pdms.model.vo.TenantVo;
import com.len.pdms.service.TenantService;
import com.len.pdms.service.provider.mapper.TenantMapper;
import com.len.util.BeanUtil;


import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import springfox.documentation.schema.Maps;

import java.util.Map;

@Service
public class TenantServiceImpl extends BaseServiceImpl<Tenant,String> implements TenantService {
    @Autowired
    TenantMapper tenantMapper;

    @Override
    public BaseMapper<Tenant, String> getMappser() {
        return tenantMapper;
    }

    @Override
    public int addTenant(TenantVo tenantVo) {
        //添加租户
        Tenant tenant=new Tenant();
        BeanUtil.copyNotNullBean(tenantVo,tenant);
        tenant.setCreatDate(DateUtil.date());
        int status=this.insertSelective(tenant);
        //添加一条用户的信息
       /* Map map= Maps.nevHashMap();*/
        return status;
    }

    @Override
    public int addRenantUser(String userName, String tenantId) {
        return 0;
    }
}
