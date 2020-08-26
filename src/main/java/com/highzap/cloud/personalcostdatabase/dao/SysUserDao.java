package com.highzap.cloud.personalcostdatabase.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.highzap.cloud.personalcostdatabase.entity.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>描述: [SysUser 数据访问层] </p>
 * <p>创建时间: 2020/08/26 </p>
 *
 * @author <a href="mailto:chenys@highzap.com" rel="nofollow">陈永松</a>
 * @version v1.0
 */
@Repository
public interface SysUserDao extends BaseMapper<SysUser> {
    /**
     * 描述: [Description]
     *
     * @param
     * @return List<SysUser> 用户列表
     * @auther 陈永松
     * @date 2020/8/26 9:22
     */
    List<SysUser> listAllUsersForNestedQuery();

    /**
     * 描述: [Description]
     *
     * @param 
     * @return
     * @throws
     * @auther 陈永松
     * @date 2020/8/26 9:48
     */
    List<SysUser> listAllUsersForUnionQuery();
}