package cn.evilcoder.security;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by evilcoder.cn on 2016/12/22.
 */

public class LoginFilter implements Filter{

    private String ssoServerUrl;

    public LoginFilter(String ssoServerUrl) {
        this.ssoServerUrl = ssoServerUrl;
    }

    public String getSsoServerUrl() {
        return ssoServerUrl;
    }

    public void setSsoServerUrl(String ssoServerUrl) {
        this.ssoServerUrl = ssoServerUrl;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession();
        boolean isLogin = session.getAttribute("isLogin") != null
                && Boolean.valueOf(session.getAttribute("isLogin").toString());
        if(request.getRequestURI().contains("/sso/login") || isLogin) {
            filterChain.doFilter(request, response);
            return;
        }
        String redirect = request.getRequestURL().toString();
        response.sendRedirect(ssoServerUrl + "?redirect=" + redirect);
    }

    @Override
    public void destroy() {

    }
}
