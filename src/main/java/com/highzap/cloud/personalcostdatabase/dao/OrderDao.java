package com.highzap.cloud.personalcostdatabase.dao;

import com.highzap.cloud.personalcostdatabase.entity.Order;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>描述: [Order 数据访问层] </p>
 * <p>创建时间: 2020/08/26 </p>
 *
 * @author <a href="mailto:chenys@highzap.com" rel="nofollow">陈永松</a>
 * @version v1.0
 */
@Repository
public interface OrderDao extends BaseMapper<Order>{

}