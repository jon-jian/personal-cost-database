package com.highzap.cloud.personalcostdatabase.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * <p>描述: [SysUser 实体类] </p>
 * <p>创建时间: 2020/08/26 </p>
 *
 * @author <a href="mailto:chenys@highzap.com" rel="nofollow">陈永松</a>
 * @version v1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUser implements Serializable {
    private static final long serialVersionUID = 202727605211263370L;
    
    private Integer id;
    
    private String userAccount;
    
    private String password;
    
    private String tenantCode;

}