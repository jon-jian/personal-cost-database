package com.highzap.cloud.personalcostdatabase.controller;

import com.highzap.cloud.personalcostdatabase.entity.SysUser;
import com.highzap.cloud.personalcostdatabase.service.SysUserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>描述: [SysUser 控制层] </p>
 * <p>创建时间: 2020/08/26 </p>
 *
 * @author <a href="mailto:chenys@highzap.com" rel="nofollow">陈永松</a>
 * @version v1.0
 */
@RestController
@RequestMapping("/sys_user")
public class SysUserController {

    /**
     * (SysUser)服务
     */
    private SysUserService sysUserService;

    @Autowired
    public SysUserController(SysUserService sysUserService){
        this.sysUserService = sysUserService;
    }

    @GetMapping("/header")
    public List<SysUser> usersFromHeader() {
        return sysUserService.selectDatasourceByHeader();
    }
    
}