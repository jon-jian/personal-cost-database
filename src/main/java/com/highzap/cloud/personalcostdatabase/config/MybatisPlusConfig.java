package com.highzap.cloud.personalcostdatabase.config;

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.servlet.http.HttpServletRequest;

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

    @Autowired
    private HttpServletRequest request;

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 新多租户插件配置,一缓和二缓遵循mybatis的规则,需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存万一出现问题
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new TenantLineInnerInterceptor(new TenantLineHandler() {
            /**
             * 获取租户 ID 值表达式，只支持单个 ID 值
             * <p>
             *
             * @return 租户 ID 值表达式
             */
            @Override
            public Expression getTenantId() {
                String tenantId = request.getParameter("tenantId");
                System.out.println("tenantId：" + tenantId);
                return new LongValue(1);
            }

            /**
             * 根据表名判断是否忽略拼接多租户条件
             * <p>
             * 默认都要进行解析并拼接多租户条件
             *
             * @param tableName 表名
             * @return 是否忽略, true:表示忽略，false:需要解析并拼接多租户条件
             */
            @Override
            public boolean ignoreTable(String tableName) {
                return false;
//                return !"user".equalsIgnoreCase(tableName);
            }

            /**
             * 获取租户字段名
             * <p>
             * 默认字段名叫: tenant_id
             *
             * @return 租户字段名
             */
            @Override
            public String getTenantIdColumn() {
                return "tenant_id";
            }
        }));
        // 如果用了分页插件注意先 add TenantLineInnerInterceptor 再 add PaginationInnerInterceptor
        // 用了分页插件必须设置 MybatisConfiguration#useDeprecatedExecutor = false
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> configuration.setUseDeprecatedExecutor(false);
    }
}