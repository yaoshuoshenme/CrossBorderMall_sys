package com.edu.controller;

import com.edu.pojo.Backuser;
import com.edu.service.BackUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class BaseController {
    @Autowired
    private BackUserService bs;

    //登录
    @PostMapping("login.do")
    public String login(String bname, String bpassword, HttpServletRequest request, Model model){
        Backuser user = bs.selctByName(bname, bpassword);
        if(user!=null){
            request.getSession().setAttribute("user",user);
            return "redirect:admin.jsp";
        }else{
            model.addAttribute("msg","账号无效");
            return "redirect:login.jsp";
        }
    }

    //注销
    @GetMapping("loginout.do")
    public String loginout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:login.jsp";
    }

}
