package com.demo716.demo.dao;

import com.demo716.demo.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUserMapper {
    List getUserById(@Param("id")Integer id);

    @Options(useGeneratedKeys=true, keyProperty="ID", keyColumn="id")
    public void insertUser(SysUser sysUser);

    public SysUser login(String name,String password);
}
