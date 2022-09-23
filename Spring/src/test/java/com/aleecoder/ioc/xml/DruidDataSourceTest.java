package com.aleecoder.ioc.xml;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * @author HuanyuLee
 * @date 2022/3/31
 */
public class DruidDataSourceTest {
    public static void main(String[] args) throws SQLException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        DruidDataSource dataSource = ac.getBean("dataSource", DruidDataSource.class);
        System.out.println(dataSource);
        DruidPooledConnection conn = dataSource.getConnection();
        System.out.println(conn);
    }
}
