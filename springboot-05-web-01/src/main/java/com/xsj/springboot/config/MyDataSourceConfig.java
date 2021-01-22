package com.xsj.springboot.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.FilterRegistration;
import javax.sql.DataSource;
import java.sql.Array;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * @author TT
 * @Date 2021/1/20 12:53
 */
//@Configuration
public class MyDataSourceConfig {

    //@ConfigurationProperties(prefix = "spring.datasource")
    //@Bean
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        // 加入web监控功能
        //druidDataSource.setFilters("stat,wall");
        return druidDataSource;
    }


    //@Bean
    public ServletRegistrationBean statViewServlet() {
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean(statViewServlet, "/druid/*");
        registrationBean.addInitParameter("loginUsername","root");
        registrationBean.addInitParameter("loginPassword","123456");
        return registrationBean;
    }
    /**
     * webStatFilter url监控
     */
    //@Bean
    public FilterRegistrationBean filterRegistrationBean() {
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> registrationBean = new FilterRegistrationBean(webStatFilter);
        registrationBean.setUrlPatterns(Arrays.asList("/*"));
        registrationBean.addInitParameter("exclusions", ".js,*.gif*,*.jpg,*.png,*.css,*.ico,/druid/*");
        return registrationBean;
    }


}
