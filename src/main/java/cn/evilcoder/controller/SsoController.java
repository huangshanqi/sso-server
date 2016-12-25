package cn.evilcoder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by huangshanqi on 2016/12/25.
 */
@Controller
@RequestMapping("/sso")
public class SsoController {

    @GetMapping("/login")
    public String login(@RequestParam("redirect") String redirect, HttpServletRequest request) {
        request.setAttribute("redirect", redirect);
        return "login";
    }

    @PostMapping(path = "/login")
    public void handleLogin(@RequestParam("redirect") String redirect,
                              @RequestParam("username") String username,
                              @RequestParam("password") String password,
                              HttpServletRequest request, HttpServletResponse response) {
        System.out.println("username=" + username);
        System.out.println("password=" + password);
        HttpSession session = request.getSession();
        session.setAttribute("isLogin", true);
        String uuid = UUID.randomUUID().toString();
        try {
            response.sendRedirect(redirect + "?token=" + uuid);
        } catch (IOException e) {e.printStackTrace();

        }
    }


}
