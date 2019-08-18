package com.len.pdms.web.controller.tenant;

import com.len.pdms.model.vo.TenantVo;
import com.len.pdms.service.TenantService;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pdms/tenant")
public class TenantController {
    @Reference
    TenantService tenantService;

    @GetMapping(value="/register")
    public String register(){
        System.out.println("sajsjahshajHSAS");
        return "/tenant-register";
    }
    //添加用户
    @PostMapping("/addTenant")
    public String addTenant(TenantVo tenantVo){
        System.out.println(tenantVo);
        System.out.println(tenantService);
        tenantService.addTenant(tenantVo);
        return "/tenant-register-success";
    }

}
