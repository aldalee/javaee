package com.aleecoder.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 配置类方式实现IOC和DI AOP 事务
 *
 * @author HuanyuLee
 * @date 2022/4/1
 */
@Configuration                                      // 配置类的标志
@ComponentScan(basePackages = "com.aleecoder.jdbc")      // 注解扫描
@PropertySource("classpath:jdbc.properties")           // 读取配置文件
@EnableAspectJAutoProxy(proxyTargetClass = true)    // 开启AOP
@EnableTransactionManagement                        // 开启事务注解
public class SpringConfig {
    @Value("${jdbc_username}")
    private String username;
    @Value("${jdbc_password}")
    private String password;
    @Value("${jdbc_driver}")
    private String driver;
    @Value("${jdbc_url}")
    private String url;

    /*创建数据库连接池*/
    @Bean   //让Spring自动执行
    public DruidDataSource getDruidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setPassword(password);
        dataSource.setUsername(username);
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        return dataSource;
    }

    /*创建JdbcTemplate对象*/
    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    /*创建事务管理器*/
    @Bean
    public PlatformTransactionManager getPlatformTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }
}
