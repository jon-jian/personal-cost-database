package com.highzap.cloud.personalcostdatabase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>描述: [Employee 实体类] </p>
 * <p>创建时间: 2020/08/25 </p>
 *
 * @author <a href="mailto:jianxb@highzap.com" rel="nofollow">简小兵</a>
 * @version v1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {
    private static final long serialVersionUID = 489353006927017489L;

    private String id;

    private String name;

    private Date bornDate;

    private String address;

    private String deptId;

    private String tenantId;

}