package com.demo716.demo.controller;

import com.demo716.demo.domain.SysUser;
import com.demo716.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class IndexController {
    @Autowired
    SysUserService sysUserService;

    @RequestMapping(value = "/getUserById",method = RequestMethod.GET)
    public List getUserById(@RequestParam(required = false) Integer id){
        List user = sysUserService.getUserById(id);
        return user;
    }

    @RequestMapping(value = "/insertUser",method = RequestMethod.POST)
    public String getUserById(@RequestParam(required = false) Integer id,
                              @RequestParam(required = true) String name,
                               @RequestParam(required = true) String sex,
                               @RequestParam(required = true) Integer age){
        SysUser sysUser = new SysUser(id,name,sex,age);
        sysUserService.insertUser(sysUser);
        return "success";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Integer toLogin(@RequestParam(required = true) String name,
                           @RequestParam(required = true) String password){
        SysUser users = sysUserService.login(name,password);
        if(users!=null&&name != null && password != null){
            return 1;
        }
        return 0;
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public Map<String,String> index(){
        Map map = new HashMap<String,String>();
        map.put("lilizi","是个小女生");
        map.put("ttt","是个恶人");
        return map;
    }
}
