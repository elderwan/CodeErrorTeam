/*
package com.ElderWan.interceptor;

import com.ElderWan.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取当前用户登录
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user==null){
            request.setAttribute("error","用户未登陆");
            request.getRequestDispatcher("index.html").forward(request,response);
            return  false;
        }
        return true;
    }
}
*/
