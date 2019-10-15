package netease.jdbc.core;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


/**
 * @author zhangyb
 * @date 2019-10-15 13:39:14
 */
@Configuration
@EnableConfigurationProperties(NeteaseJdbcProperties.class)
public class NeteaseJdbcConfiguration {

    //数据库连接池
    @Bean
    @ConditionalOnProperty(name = "netease.jdbc.enable",havingValue = "true")
    public DruidDataSource druidDataSource(NeteaseJdbcProperties neteaseJdbcProperties){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(neteaseJdbcProperties.getUrl());
        druidDataSource.setUsername(neteaseJdbcProperties.getUsername());
        druidDataSource.setPassword(neteaseJdbcProperties.getPassword());
        druidDataSource.setDriverClassName(neteaseJdbcProperties.getDriverClassName());
        return druidDataSource;
    }

    //jdbc连接时，需要传入数据源！！！
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return  new JdbcTemplate(dataSource);
    }

}
