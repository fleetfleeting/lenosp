package com.len.pdms.service;

import com.len.base.BaseService;
import com.len.pdms.model.entity.Tenant;
import com.len.pdms.model.vo.TenantVo;


public interface TenantService extends BaseService<Tenant,String> {
    int addTenant(TenantVo tenantVo);
    int addRenantUser(String userName,String tenantId);
}
