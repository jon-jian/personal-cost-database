package com.highzap.cloud.personalcostdatabase.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.highzap.cloud.personalcostdatabase.dao.EmployeeDao;
import com.highzap.cloud.personalcostdatabase.entity.Employee;
import com.highzap.cloud.personalcostdatabase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>描述: [Employee 服务实现层] </p>
 * <p>创建时间: 2020/08/25 </p>
 *
 * @author <a href="mailto:jianxb@highzap.com" rel="nofollow">简小兵</a>
 * @version v1.0
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeDao, Employee> implements EmployeeService {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

}