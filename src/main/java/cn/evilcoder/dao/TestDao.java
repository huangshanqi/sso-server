package cn.evilcoder.dao;

import cn.evilcoder.model.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by evilcoder.cn on 2016/12/22.
 */
@Repository
public class TestDao extends BaseDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseDao.class);
    private static final String addTestSql = "insert into t_test";
    private static final String listTestSql = "select * from t_test";


    public long addTest(Test test) {
        return 1L;
    }

    public List<Test> listTest() {
        List<Test> result = new ArrayList<>();
        jdbcTemplate.query(listTestSql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                result.add(new Test().withId(resultSet.getLong("id"))
                        .withContent(resultSet.getString("content")));
            }
        });
        return result;
    }
}
