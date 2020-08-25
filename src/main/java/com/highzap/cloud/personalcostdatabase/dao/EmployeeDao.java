package com.highzap.cloud.personalcostdatabase.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.highzap.cloud.personalcostdatabase.entity.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>描述: [Employee 数据访问层] </p>
 * <p>创建时间: 2020/08/25 </p>
 *
 * @author <a href="mailto:jianxb@highzap.com" rel="nofollow">简小兵</a>
 * @version v1.0
 */
@Repository
public interface EmployeeDao extends BaseMapper<Employee> {


    List<Employee> list();

    int insertOne(@Param("emp") Employee employee);

    List<Employee> getBySQL();

    List<Employee> getBySQL2();
}