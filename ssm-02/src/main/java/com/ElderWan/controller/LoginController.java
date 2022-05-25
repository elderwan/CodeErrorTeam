package com.ElderWan.controller;

import com.ElderWan.entity.User;
import com.ElderWan.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    //原版登陆
/*    @RequestMapping("/login")
    public String login(User user, Map map, HttpSession session){
        System.out.println("name---------->"+user.getUser_name());
        System.out.println("pwd----------->"+user.getPwd());
        User u = this.userService.login(user.getUser_name(), user.getPwd());
        if(u!=null){
            session.setAttribute("user",u);
            return "redirect:main.html";

        }
        map.put("error","用户名或密码不正确");
        return "index";
    }*/

    //  shiro登陆
    @RequestMapping("/login")
    public String login(User user, Map map, HttpSession session) {
        System.out.println("name---------->" + user.getUser_name());
        System.out.println("pwd----------->" + user.getPwd());
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUser_name(),user.getPwd());
        System.out.println("========------========"+token);
        Subject subject = SecurityUtils.getSubject();
                try{
                    subject.login(token);
                    return "redirect:main.html";
                }catch (Exception e){
                    map.put("error","Login failed!!");
                    return "index";
                }
    }
}
