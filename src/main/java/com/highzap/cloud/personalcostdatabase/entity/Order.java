package com.highzap.cloud.personalcostdatabase.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * <p>描述: [Order 实体类] </p>
 * <p>创建时间: 2020/08/26 </p>
 *
 * @author <a href="mailto:chenys@highzap.com" rel="nofollow">陈永松</a>
 * @version v1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {
    private static final long serialVersionUID = -98127763506940815L;
    
    private Integer id;
    
    private String orderNumber;
    
    private String userAccount;

}