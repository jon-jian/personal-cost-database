package com.highzap.cloud.personalcostdatabase.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.highzap.cloud.personalcostdatabase.entity.SysUser;
import com.highzap.cloud.personalcostdatabase.dao.SysUserDao;
import com.highzap.cloud.personalcostdatabase.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>描述: [SysUser 服务实现层] </p>
 * <p>创建时间: 2020/08/26 </p>
 *
 * @author <a href="mailto:chenys@highzap.com" rel="nofollow">陈永松</a>
 * @version v1.0
 */
@Service
@DS("default")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {
    
    private SysUserDao sysUserDao;
    
    @Autowired
    public SysUserServiceImpl(SysUserDao sysUserDao) {
        this.sysUserDao = sysUserDao;
    }

    @Override
    public List<SysUser> selectDatasourceByDefault() {
        return baseMapper.selectList(null);
    }

    @Override
    @DS("#session.tenantCode")
    public List<SysUser> selectDatasourceBySession() {
        return baseMapper.selectList(null);
    }

    @Override
    @DS("#header.tenantCode")
    public List<SysUser> selectDatasourceByHeader() {
        return baseMapper.selectList(null);
    }

    @Override
    @DS("#tenantCode")
    public List<SysUser> selectDatasourceByKey(String tenantCode) {
        return baseMapper.selectList(null);
    }

    @Override
    @DS("#user.tenantCode")
    public List<SysUser> selectDatasourceByTenant(SysUser user) {
        return baseMapper.selectList(null);
    }
}