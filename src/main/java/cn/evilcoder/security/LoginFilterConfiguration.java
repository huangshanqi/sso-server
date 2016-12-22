package cn.evilcoder.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by evilcoder.cn on 2016/12/22.
 */
@Configuration
public class LoginFilterConfiguration {

    @Value("${sso.server.url}")
    private String ssoServerUrl;
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        LoginFilter loginFilter = new LoginFilter(ssoServerUrl);
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(loginFilter);
        return registrationBean;
    }
}
