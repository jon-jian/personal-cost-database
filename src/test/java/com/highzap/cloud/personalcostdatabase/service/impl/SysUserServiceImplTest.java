package com.highzap.cloud.personalcostdatabase.service.impl;

import com.highzap.cloud.personalcostdatabase.dao.SysUserDao;
import com.highzap.cloud.personalcostdatabase.entity.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


/**
 * SysUserServiceImpl Tester.
 * <p>Description: [Description...] </p>
 *
 * @author <a href="mailto:chenys@highzap.com" rel="nofollow">Chenys</a>
 * @version v1.0
 * @CreateDate 08/26/2020
 */
@SpringBootTest
public class SysUserServiceImplTest {

    @Autowired
    private SysUserDao userDao;

    // 新增
    @Test
    public void caseAdd() {
        SysUser sysUser = new SysUser();
        sysUser.setUserAccount("chenys");
        sysUser.setPassword("chenys");
        userDao.insert(sysUser);
    }

    // 普通查询
    @Test
    public void caseSingleQuery() {
        userDao.selectList(null);
    }

    // 嵌套查询
    @Test
    public void caseNestedQuery() {
        userDao.listAllUsersForNestedQuery();
    }

    // 关联查询
    @Test
    public void caseUnionQuery() {
        userDao.listAllUsersForUnionQuery();
    }

    // 删除
    @Test
    public void caseDelete() {
        List<SysUser> sysUsers = userDao.selectList(null);
        SysUser sysUser = new SysUser();
        sysUser.setId(sysUsers.get(0).getId());
        userDao.deleteById(sysUser);
    }

    // 修改
    @Test
    public void caseUpdate() {
        List<SysUser> sysUsers = userDao.selectList(null);
        SysUser sysUser = new SysUser();
        sysUser.setId(sysUsers.get(0).getId());
        sysUser.setUserAccount("zhangsan");
        userDao.updateById(sysUser);
    }


}
