package cn.ww.system.service.impl;

import cn.ww.model.entity.SysRole;
import cn.ww.model.entity.SysUserRole;
import cn.ww.model.vo.AssginRoleVo;
import cn.ww.model.vo.SysRoleQueryVo;
import cn.ww.system.mapper.SysRoleMapper;
import cn.ww.system.mapper.SysUserRoleMapper;
import cn.ww.system.service.SysRoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Suww
 * @createTime 2022-10-26
 */

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    
    @Override
    public IPage<SysRole> selectPage(Page<SysRole> pageParam, SysRoleQueryVo sysRoleQueryVo) {
        return baseMapper.selectPage(pageParam,sysRoleQueryVo);
    }

    @Override
    public Map<String, Object> getRoles(String userId) {
        List<SysRole> roles = baseMapper.selectList(null);

        QueryWrapper<SysUserRole> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);
        List<SysUserRole> userRolesList = sysUserRoleMapper.selectList(wrapper);

        ArrayList<String> userRoleIds = new ArrayList<>();
        for (SysUserRole userRole : userRolesList) {
            String roleId = userRole.getRoleId();
            userRoleIds.add(roleId);
        }
        //创建返回的Map
        Map<String, Object> userRolesMap = new HashMap<>();
        userRolesMap.put("allRoles",roles);
        userRolesMap.put("userRoleIds",userRoleIds);
        return userRolesMap;
    }

    @Override
    public void doAssign(AssginRoleVo assignRoleVo) {
        QueryWrapper<SysUserRole> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",assignRoleVo.getUserId());
        sysUserRoleMapper.delete(wrapper);

        List<String> roleIdList = assignRoleVo.getRoleIdList();
        for (String roleId : roleIdList) {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUserId(assignRoleVo.getUserId());
            sysUserRole.setRoleId(roleId);
            sysUserRoleMapper.insert(sysUserRole);
        }
    }
}
