package cn.evilcoder.service;

import cn.evilcoder.model.Test;

import java.util.List;

/**
 * Created by evilcoder.cn on 2016/12/22.
 */
public interface TestService {

    long addTest(Test test);
    List<Test> listTest();
}
