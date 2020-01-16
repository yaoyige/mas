package com.baomidou.test.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: yyg
 * @Date: 2020/1/7 13:55
 * @Description:
 */
@Controller
public class TemplatesController {

    @GetMapping("/templates")
    public  String test(HttpServletRequest request) {
        //逻辑处理
        request.setAttribute("key", "hello world");
        return "index";
    }
}
