package com.chenmt.attachment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program attachment
 * @description: 首页控制层
 * @author: chenmet
 * @create: 2020/04/09 11:02
 */
@Controller
public class IndexController {

    /**
     * 默认跳转首页
     * @return
     */
    @RequestMapping("/")
    public String index(){
        return "index";
    }

}
