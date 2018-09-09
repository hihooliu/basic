package com.hioo.basic.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.ResourceServlet;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@Configuration
public class DruidConfig {

    /** 注入到容器
     * @return
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }

    // 配置Druid监控
    // 1.配置管理后台的Servlet
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");

        //配置参数
        Map<String,String> initParams = new HashMap<>();
        //配置登录名
        initParams.put(ResourceServlet.PARAM_NAME_USERNAME,"amdin");
        //配置登录密码
        initParams.put(ResourceServlet.PARAM_NAME_PASSWORD,"123456");
        //配置允许访问路径，默认允许素有访问
        initParams.put(ResourceServlet.PARAM_NAME_ALLOW,"");
        bean.setInitParameters(initParams);
        return bean;
    }

    //配置一个web监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        //配置参数
        Map<String,String> initParams = new HashMap<>();
        //配置忽略的文件
        initParams.put("exclusions","*.css,*.js,*.png,*.jpg,/druid/*");
        bean.setInitParameters(initParams);

        // 配置拦截器拦截规则
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }

}
