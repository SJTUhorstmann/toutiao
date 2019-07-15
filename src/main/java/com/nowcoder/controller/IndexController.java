package com.nowcoder.controller;

import com.nowcoder.aspect.LogAspect;
import com.nowcoder.model.User;
import com.nowcoder.service.ToutiaoService;
import com.sun.deploy.net.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by lenovo on 2019/7/14.
 */
//@Controller
public class IndexController {
    @Autowired
    private ToutiaoService toutiaoService;

    @RequestMapping(path={"/","/index"})
    @ResponseBody
    public String index(){
        return "Hello World"+toutiaoService.say();
    }

    @RequestMapping(path={"/profile/{groupId}/{userId}"})
    @ResponseBody
    public String profile(@PathVariable("groupId") String groupId,
                          @PathVariable("userId") int userId,
                          @RequestParam(value = "type",defaultValue = "1") int type,
                          @RequestParam(value = "key",defaultValue = "0") String key){
        return groupId+": "+userId+":"+type+":"+key;
    }

    @RequestMapping("/vm")
    public String news(Model model){
        model.addAttribute("value1","vv1");
        model.addAttribute("value2","vv2");
        model.addAttribute("user",new User("Jim"));
        return "news";
    }

    @RequestMapping("/request")
    @ResponseBody
    public String request(HttpRequest httpRequest,
                          HttpResponse httpResponse,
                          HttpSession httpSession){
        return "略";
    }
}
