package com.qidao.framework.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages  = DbSourceBusiness.PACKAGE , sqlSessionFactoryRef = "clusterSqlSessionFactory")

public class DbSourceBusiness {
    // 精确到 cluster 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.qidao.qidao.**.mapper";
    private static final String MAPPER_LOCATION = "classpath:qidao/**/*Mapper.xml";
    private static final String DOMAIN_PACKAGE = "com.qidao.project.**.domain";

    @Value("${spring.datasource.druid.business.url}")
    private String dbUrl;

    @Value("${spring.datasource.druid.business.username}")
    private String username;

    @Value("${spring.datasource.druid.business.password}")
    private String password;

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;



    @Bean(name="clusterDataSource")   //声明其为Bean实例
    public DataSource clusterDataSource() {
        DruidDataSource datasource = new DruidDataSource();

        datasource.setUrl(this.dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
        return datasource;
    }

    @Bean(name = "clusterTransactionManager")
    public DataSourceTransactionManager clusterTransactionManager() {
        return new DataSourceTransactionManager(clusterDataSource());
    }

    @Bean(name = "clusterSqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("clusterDataSource") DataSource culsterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(culsterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(DbSourceBusiness.MAPPER_LOCATION));
        sessionFactory.setTypeAliasesPackage(DOMAIN_PACKAGE);
        //mybatis 数据库字段与实体类属性驼峰映射配置
        sessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return sessionFactory.getObject();
    }
}
