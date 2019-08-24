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
        System.out.println("注册页面跳转页");
        return "/pdms/tenant-register";
    }
    //添加用户
    @PostMapping("/addTenant")
    public String addTenant(TenantVo tenantVo ,Model model){
        System.out.println("注册页面正式面");
        tenantService.addTenant(tenantVo);
        model.addAttribute("username",tenantVo.getUsername());
        model.addAttribute("password",tenantVo.getPassword());
        return "/pdms/tenant-register-success";
    }

}
