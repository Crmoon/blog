package com.demo716.demo.service.Impl;

import com.demo716.demo.dao.SysUserMapper;
import com.demo716.demo.domain.SysUser;
import com.demo716.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public List getUserById(Integer id){
        return sysUserMapper.getUserById(id);
    }

    @Override
    public int insertUser(SysUser sysUser){
        sysUserMapper.insertUser(sysUser);
        if(sysUserMapper.getUserById(sysUser.getId())!=null){
            return 1;
        }
        return 0;
    }

    @Override
    public SysUser login(String name,String password){
        return sysUserMapper.login(name,password);
    }
}
