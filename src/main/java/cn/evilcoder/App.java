package cn.evilcoder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Created by evilcoder.cn on 2016/12/20.
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class App {
    public static void main(String[] args) throws Exception{
        SpringApplication.run(App.class, args);
    }
}
