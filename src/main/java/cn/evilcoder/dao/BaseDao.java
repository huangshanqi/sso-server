package cn.evilcoder.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created by evilcoder.cn on 2016/12/21.
 */
@Repository("baseDao")
public class BaseDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseDao.class);

    @Value("${db.timeout.second:10}")
    public int queryTimeout;

    @Resource(name = "jdbcTemplate")
    public JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        jdbcTemplate.setQueryTimeout(this.queryTimeout);
        LOGGER.info("jdbcTemplate: {}", jdbcTemplate);
    }

}
