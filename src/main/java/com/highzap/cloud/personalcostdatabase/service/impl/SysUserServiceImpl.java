package com.highzap.cloud.personalcostdatabase.service.impl;

import com.highzap.cloud.personalcostdatabase.entity.SysUser;
import com.highzap.cloud.personalcostdatabase.dao.SysUserDao;
import com.highzap.cloud.personalcostdatabase.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>描述: [SysUser 服务实现层] </p>
 * <p>创建时间: 2020/08/26 </p>
 *
 * @author <a href="mailto:chenys@highzap.com" rel="nofollow">陈永松</a>
 * @version v1.0
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {
    
    private SysUserDao sysUserDao;
    
    @Autowired
    public SysUserServiceImpl(SysUserDao sysUserDao) {
        this.sysUserDao = sysUserDao;
    }
    
}