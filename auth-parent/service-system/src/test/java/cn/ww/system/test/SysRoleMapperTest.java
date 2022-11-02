package cn.ww.system.test;

import cn.ww.model.entity.SysRole;
import cn.ww.system.mapper.SysRoleMapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

/**
 * @author Suww
 * @createTime 2022-10-26
 */
@SpringBootTest
public class SysRoleMapperTest {
    
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Test
    public void select() {
        List<SysRole> users = sysRoleMapper.selectList(null);
        for (SysRole sysRole : users) {
            System.out.println("sysRole = " + sysRole);
        }
    }
    
    @Test
    public void add() {
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("测试角色");
        sysRole.setRoleCode("testManager");
        sysRole.setDescription("测试角色");
        int result = sysRoleMapper.insert(sysRole);
        System.out.println(result);
    }

    @Test
    public void update() {
        SysRole sysRole = sysRoleMapper.selectById(1);
        sysRole.setDescription("超级管理员");
        sysRoleMapper.updateById(sysRole);
    }

    @Test
    public void deleteById() {
        int result = sysRoleMapper.deleteById(2L);
        System.out.println(result);
    }

    @Test
    public void deleteByIds() {
        int result = sysRoleMapper.deleteBatchIds(Arrays.asList(5, 6));
        System.out.println(result);
    }

    @Test
    public void selectByWrapper() {
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
        
       /* wrapper.eq("role_name","管理员");*/

        wrapper.like("role_name","管理员");
        
        List<SysRole> sysRoles = sysRoleMapper.selectList(wrapper);
        System.out.println(sysRoles);
    }
    
}
