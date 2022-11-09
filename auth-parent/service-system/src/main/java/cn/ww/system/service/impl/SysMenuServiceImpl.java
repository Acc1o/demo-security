package cn.ww.system.service.impl;


import cn.ww.model.entity.SysMenu;
import cn.ww.model.entity.SysRoleMenu;
import cn.ww.model.entity.SysUser;
import cn.ww.model.vo.AssginMenuVo;
import cn.ww.system.exception.ExceptionHandle;
import cn.ww.system.mapper.SysMenuMapper;
import cn.ww.system.mapper.SysRoleMenuMapper;
import cn.ww.system.service.SysMenuService;
import cn.ww.system.utils.MenuHelper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author Suww
 * @since 2022-11-09
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;
    
    @Override
    public List<SysMenu> findNodes() {
        
        List<SysMenu> sysMenuList = this.list();
        List<SysMenu> result = MenuHelper.buildTree(sysMenuList);
        return result;
    }

    @Override
    public void removeMenuById(Long id) {
        QueryWrapper<SysMenu> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id",id);
        Integer count = baseMapper.selectCount(wrapper);
        if(count > 0){
            throw new ExceptionHandle(201,"请先删除子菜单");
        }
        baseMapper.deleteById(id);
    }

    @Override
    public void updateStatus(Long id, Integer status) {
        SysMenu sysMenu = baseMapper.selectById(id);
        sysMenu.setStatus(status);
        baseMapper.updateById(sysMenu);
    }

    @Override
    public List<SysMenu> findSysMenuByRoleId(String roleId) {
        QueryWrapper<SysMenu> menuQueryWrapper = new QueryWrapper<>();
        menuQueryWrapper.eq("status",1);
        List<SysMenu> menuList = baseMapper.selectList(menuQueryWrapper);

        QueryWrapper<SysRoleMenu> roleMenuQueryWrapper = new QueryWrapper<>();
        roleMenuQueryWrapper.eq("role_id",roleId);
        List<SysRoleMenu> roleMenus = sysRoleMenuMapper.selectList(roleMenuQueryWrapper);

        List<String> roleMenuIds = new ArrayList<>();

        for (SysRoleMenu roleMenu : roleMenus) {
            String menuId = roleMenu.getMenuId();
            roleMenuIds.add(menuId);
        }

        for (SysMenu sysMenu : menuList) {
            if(roleMenuIds.contains(sysMenu.getId())){
                sysMenu.setSelect(true);
            }else {
                sysMenu.setSelect(false);
            }
        }
        
        return MenuHelper.buildTree(menuList);
    }

    @Override
    public void doAssign(AssginMenuVo assginMenuVo) {
        QueryWrapper<SysRoleMenu> wrapper = new QueryWrapper<>();
        wrapper.eq("role_id",assginMenuVo.getRoleId());
        sysRoleMenuMapper.delete(wrapper);
        
        List<String> menuIdList = assginMenuVo.getMenuIdList();
        for (String menuId : menuIdList) {
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setMenuId(menuId);
            sysRoleMenu.setRoleId(assginMenuVo.getRoleId());
            sysRoleMenuMapper.insert(sysRoleMenu);
        }
    }
}
