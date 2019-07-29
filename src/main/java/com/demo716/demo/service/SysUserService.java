package com.demo716.demo.service;

import com.demo716.demo.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface SysUserService {
    List getUserById(Integer id);

    public int insertUser(SysUser sysUser);

    public SysUser login(String name,String password);

}
