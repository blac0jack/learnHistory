package com.jyc.website.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 *
 * @author: @我没有三颗心脏
 * @create: 2018-05-08-下午 16:46
 */
@RestController
public class IndexController {

    @RequestMapping("/hello")
    public String hello() {
        return "2019-06-25 docker 自动部署成功";
    }
}