package com.highzap.cloud.personalcostdatabase.service;

import com.highzap.cloud.personalcostdatabase.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>描述: [SysUser 服务层] </p>
 * <p>创建时间: 2020/08/26 </p>
 *
 * @author <a href="mailto:chenys@highzap.com" rel="nofollow">陈永松</a>
 * @version v1.0
 */
public interface SysUserService extends IService<SysUser> {

    List<SysUser> selectDatasourceByDefault();

    List<SysUser> selectDatasourceBySession();

    List<SysUser> selectDatasourceByHeader();

    List<SysUser> selectDatasourceByKey(String tenantCode);

    List<SysUser> selectDatasourceByTenant(SysUser user);
}