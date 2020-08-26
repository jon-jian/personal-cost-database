package com.highzap.cloud.personalcostdatabase.config;

import com.baomidou.mybatisplus.extension.parsers.DynamicTableNameParser;
import com.baomidou.mybatisplus.extension.parsers.ITableNameHandler;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

/**
 * <p>描述: [MyBatis 配置类] </p>
 * <p>创建时间: 2020/8/21 </p>
 *
 * @author <a href="mailto:jianxb@highzap.com" rel="nofollow">简小兵</a>
 * @version v1.0
 */
@EnableTransactionManagement
@MapperScan({"com.highzap.cloud.personalcostdatabase.dao"})
@Configuration
public class MybatisPlusConfig {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 动态表名解析器
        DynamicTableNameParser dynamicTableNameParser = new DynamicTableNameParser();
        // 解析规则
        dynamicTableNameParser.setTableNameHandlerMap(new HashMap<String, ITableNameHandler>(2) {{
            put("sys_user", (metaObject, sql, tableName) -> getTableName(tableName));
            put("product", (metaObject, sql, tableName) -> getTableName(tableName));
        }});
        paginationInterceptor.setSqlParserList(Collections.singletonList(dynamicTableNameParser));
        return paginationInterceptor;
    }


    public String getTableName(String tableName) {
        // 模拟表名生成规则
        return tableName + "_a";
    }


}