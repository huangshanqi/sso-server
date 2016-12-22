package cn.evilcoder.service.impl;

import cn.evilcoder.dao.TestDao;
import cn.evilcoder.model.Test;
import cn.evilcoder.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by evilcoder.cn on 2016/12/22.
 */
@Service
public class TestServiceImpl implements TestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestServiceImpl.class);

    @Autowired
    private TestDao testDao;

    @Override
    public long addTest(Test test) {
        return 0;
    }

    @Override
    public List<Test> listTest() {
        return testDao.listTest();
    }
}
