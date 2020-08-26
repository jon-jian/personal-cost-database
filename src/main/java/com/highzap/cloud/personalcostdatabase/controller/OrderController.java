package com.highzap.cloud.personalcostdatabase.controller;

import com.highzap.cloud.personalcostdatabase.service.OrderService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>描述: [Order 控制层] </p>
 * <p>创建时间: 2020/08/26 </p>
 *
 * @author <a href="mailto:chenys@highzap.com" rel="nofollow">陈永松</a>
 * @version v1.0
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    /**
     * (Order)服务
     */
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }
    
}