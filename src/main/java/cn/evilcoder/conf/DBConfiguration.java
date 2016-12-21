package cn.evilcoder.conf;

import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Created by evilcoder.cn on 2016/12/21.
 */
@Configuration
public class DBConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(DBConfiguration.class);

    @Value("${db.isEmbedded:true}")
    Boolean databaseIsEmbedded;

    @Value("${db.url:jdbc:mysql://ip:port/db?useUnicode=true&amp;characterEncoding=UTF-8}")
    String databaseUrl;

    @Value("${db.username:test}")
    String databaseUsername;

    @Value("${db.password:test}")
    String databasePassword;

    @Value("{db.driver.class:com.mysql.jdbc.Driver}")
    String databaseDriver;

    @Bean(name = "jdbcTemplate")
    public JdbcTemplate logicalJdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource(databaseUrl, databaseUsername, databasePassword));
        return jdbcTemplate;
    }


    public DataSource dataSource(String databaseUrl, String databaseUsername, String databasePassword) {
        if (databaseIsEmbedded) {
            return embeddedHsqlDataSource();
        } else {
            return mysqlDataSource(databaseUrl, databaseUsername, databasePassword);
        }
    }

    public DataSource embeddedHsqlDataSource() {
        LOGGER.debug("create embeddedDatabase HSQL");
        EmbeddedDatabase embeddedDatabase = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
                .addScript("classpath:hsql_init.sql")
                .addScript("classpath:schema_quota.sql").build();
        return embeddedDatabase;
    }

    public DataSource mysqlDataSource(String databaseUrl, String databaseUsername, String databasePassword) {
        PoolProperties p = new PoolProperties();
        p.setUrl(databaseUrl);
        p.setDriverClassName(databaseDriver);
        p.setUsername(databaseUsername);
        p.setPassword(databasePassword);
        p.setJmxEnabled(true);

        // when database broke, reconnect
        p.setTestWhileIdle(true);
        p.setTestOnBorrow(true);
        p.setValidationQuery("SELECT 1");
        p.setValidationInterval(30000);

        p.setMaxActive(100);

        // idle connections survive 60s by default
        p.setMaxIdle(10);

        // if idle for long time, we don't keep them
        p.setMinIdle(0);
        p.setMaxWait(10000);

        // If connection is broken
        p.setLogAbandoned(true);
        p.setRemoveAbandoned(true);
        p.setRemoveAbandonedTimeout(60);
        p.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"
                + "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        dataSource.setPoolProperties(p);
        return dataSource;
    }
}
