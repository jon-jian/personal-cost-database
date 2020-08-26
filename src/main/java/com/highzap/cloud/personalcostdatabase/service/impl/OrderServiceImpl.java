package com.highzap.cloud.personalcostdatabase.service.impl;

import com.highzap.cloud.personalcostdatabase.entity.Order;
import com.highzap.cloud.personalcostdatabase.dao.OrderDao;
import com.highzap.cloud.personalcostdatabase.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>描述: [Order 服务实现层] </p>
 * <p>创建时间: 2020/08/26 </p>
 *
 * @author <a href="mailto:chenys@highzap.com" rel="nofollow">陈永松</a>
 * @version v1.0
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements OrderService {
    
    private OrderDao orderDao;
    
    @Autowired
    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
    
}