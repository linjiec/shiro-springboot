package com.shiro.springboot.controller;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * LoginController
 *
 * @author linjie
 * @date 2018/8/26
 */
@Controller
public class LoginController {

    /**
     * 登录验证方法，其实在登录之前shiro就通过拦截器调用Realm进行了验证，验证完毕后才会进入该方法
     *
     * @param request
     * @param map
     * @return
     * @throws Exception
     */
    @RequestMapping(value={"/userlogin"})
    public String userLogin(HttpServletRequest request, Map<String,String> map) throws Exception{
        System.out.println("userLogin()");
        String exception = (String)request.getAttribute("shiroLoginFailure");
        System.out.println("exception="+exception);
        String msg="";
        if(exception!=null){
            if(UnknownAccountException.class.getName().equals(exception)){
                msg="UnknownAccountException ---->账号不存在！";
                System.out.println(msg);
            }else if(IncorrectCredentialsException.class.getName().equals(exception)){
                msg="IncorrectCredentialsException ---->密码不正确！";
                System.out.println(msg);
            }else if("kaptchaValidateFailed".equals(exception)){
                msg="kaptchaValidateFailed ---->验证码错误！";
                System.out.println(msg);
            }else {
                msg = "else >> "+exception;
                System.out.println("else -- >" + exception);
            }
        }
        map.put("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理
        return "/login";
    }

    /**
     * 下面这些是为了满足地址转换
     * @return
     */
    @RequestMapping("/403")
    public String unauthorizedRole(){
        System.out.println("------没有权限-------");
        return "403";
    }
    @RequestMapping({"/","/index"})
    public String index(){
        return"/index";
    }
    @RequestMapping({"/login"})
    public String login(){
        return"/login";
    }

}
