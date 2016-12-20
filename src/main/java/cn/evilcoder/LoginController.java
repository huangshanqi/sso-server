package cn.evilcoder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by evilcoder.cn on 2016/12/20.
 */
@Controller
public class LoginController {

    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @ResponseBody
    @PostMapping(path = "/login")
    public Object handleLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
        System.out.println("username=" + username);
        System.out.println("password=" + password);
        return "ok";
    }
}
