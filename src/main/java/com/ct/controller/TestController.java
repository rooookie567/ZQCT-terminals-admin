package com.ct.controller;


import com.ct.entity.User;
import com.ct.entity.terminals;
import com.ct.service.terminalsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import java.util.*;

@Controller
public class TestController {

    @Resource
    private terminalsService terminalsService;

    @RequestMapping("/test")
    public String queryAll(Model model){
        List<terminals> terminalsList= terminalsService.queryList();
        model.addAttribute("terminalsList",terminalsList);
        return "login";
    }

    @ResponseBody
    @RequestMapping("/testjson")
    public Object getJson(){

        List<User> list = new ArrayList<>();
        User user1 = new User();
        User user2 = new User();
        user1.setId(1);
        user1.setEmail("xiezip@chinatelecom.com");
        user1.setUsername("zz");
        user1.setPassword("zz");
        user1.setPerm("up");
        user1.setRole("admin");
        user1.setPhone("123456");
        user1.setSex("m");

        user2.setId(2);
        user2.setEmail("xzp@chinatelecom.com");
        user2.setUsername("pp");
        user2.setPassword("pp");
        user2.setPerm("up");
        user2.setRole("admin");
        user2.setPhone("654321");
        user2.setSex("f");

        list.add(user1);
        list.add(user2);

        Map<String,Object> map = new LinkedHashMap<>();
        map.put("status",200);
        map.put("message","");
        map.put("total",8);
        map.put("item",list);
        return map;
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/success")
    public String success(){
        return "success";
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/json")
    public String json(){
        return "json";
    }
}
