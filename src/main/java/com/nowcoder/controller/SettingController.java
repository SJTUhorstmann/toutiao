package com.nowcoder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lenovo on 2019/7/14.
 */
@Controller
public class SettingController {
    @RequestMapping("/setting")
    @ResponseBody
    public String setting(){
        return "Setting is OK";
    }
}
