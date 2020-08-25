package com.highzap.cloud.personalcostdatabase;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.highzap.cloud.personalcostdatabase.dao.EmployeeDao;
import com.highzap.cloud.personalcostdatabase.entity.Employee;
import com.highzap.cloud.personalcostdatabase.service.EmployeeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * <p>描述: [类型描述] </p>
 * <p>创建时间: 2020/8/25 </p>
 *
 * @author <a href="mailto:jianxb@highzap.com" rel="nofollow">简小兵</a>
 * @version v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeTests {


    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeDao employeeDao;

    //  测试使用租户id
    final String tenanId = "1";

    /**
     * 使用Mybatis-Plus Service CRUD 进行多租户测试
     */
    @Test
    public void testServiceGetList() {

        List<Employee> list = employeeService.list();

        list.forEach(v -> {
            //  如果查询出来的数据有其他租户的
            Assert.assertFalse(!tenanId.equals(v.getTenantId()));
        });

    }

    /**
     * 使用Mybatis Service CRUD 语句进行多租户测试
     */
    @Test
    public void testServiceAdd() {
        Employee employee = new Employee();
        employee.setId(UUID.randomUUID().toString());
        employee.setName("service测试专用");

        boolean isSave = employeeService.save(employee);

        LambdaQueryWrapper<Employee> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(Employee::getId, employee.getId());

        Employee selectEmployee = employeeDao.selectOne(lambdaQueryWrapper);

        Assert.assertTrue(selectEmployee.getTenantId().equals(this.tenanId));
    }

    /**
     * 使用Mybatis Service CRUD 语句进行多租户测试
     */
    @Test
    public void testServiceUpdate() {
        Employee employee = new Employee();
        employee.setId("88");
        employee.setName("service测试专用");

        boolean isSave = employeeService.updateById(employee);

        LambdaQueryWrapper<Employee> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(Employee::getId, employee.getId());

        Employee selectEmployee = employeeDao.selectOne(lambdaQueryWrapper);

        Assert.assertTrue(selectEmployee.getTenantId().equals(this.tenanId));
    }

    /**
     * 使用Mybatis-Plus Dao CRUD 进行多租户测试
     */
    @Test
    public void testDaoGetList() {

        List<Employee> list = employeeDao.selectList(null);

        list.forEach(v -> {
            //  如果查询出来的数据有其他租户的
            Assert.assertFalse(!tenanId.equals(v.getTenantId()));
        });

    }

    /**
     * 使用Mybatis 原生SQL 语句进行多租户测试
     */
    @Test
    public void testDaoGetListBySQL() {

        List<Employee> list = employeeDao.list();

        list.forEach(v -> {
            //  如果查询出来的数据有其他租户的
            Assert.assertFalse(!tenanId.equals(v.getTenantId()));
        });
    }

    /**
     * 使用Mybatis 原生SQL 语句进行多租户测试
     */
    @Test
    public void testDaoInsert() {
        Employee employee = new Employee();
        employee.setId(UUID.randomUUID().toString());
        employee.setName("dao测试专用");

        int rowCount = employeeDao.insertOne(employee);

        LambdaQueryWrapper<Employee> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(Employee::getId, employee.getId());

        Employee selectEmployee = employeeDao.selectOne(lambdaQueryWrapper);

        Assert.assertTrue(selectEmployee.getTenantId().equals(this.tenanId));
    }


    /**
     * 使用Mybatis 原生SQL 语句进行多租户测试
     * 执行完后的SQL : SELECT e.* FROM employee e INNER JOIN dept d ON d.id = e.dept_id AND d.tenant_id = 1 WHERE e.tenant_id = 1
     */
    @Test
    public void testGetBySQL() {

        List<Employee> list = employeeDao.getBySQL();


        list.forEach(v -> {
            //  如果查询出来的数据有其他租户的
            Assert.assertFalse(!tenanId.equals(v.getTenantId()));
        });
    }

    /**
     * 使用Mybatis 原生SQL 语句进行多租户测试
     * 执行完后的SQL : SELECT e.* FROM employee e WHERE e.id IN (SELECT id FROM employee WHERE tenant_id = 1) AND e.tenant_id = 1
     */
    @Test
    public void testGetBySQL2() {

        List<Employee> list = employeeDao.getBySQL2();


        list.forEach(v -> {
            //  如果查询出来的数据有其他租户的
            Assert.assertFalse(!tenanId.equals(v.getTenantId()));
        });
    }

    /**
     * 使用Mybatis 原生SQL 语句进行多租户测试
     * 执行完后的SQL :
     */
    @Test
    public void testGetBySQL3() {

        List<Employee> list = employeeDao.getBySQL3();

        System.out.println(list);
    }


}
