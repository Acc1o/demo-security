package cn.ww.system.service;


import cn.ww.model.entity.SysMenu;
import cn.ww.model.vo.AssginMenuVo;
import cn.ww.model.vo.RouterVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author Suww
 * @since 2022-11-09
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
     * 菜单列表
     * @return
     */
    List<SysMenu> findNodes();

    /**
     * 删除菜单
     * @param id 菜单id
     * @return
     */
    void removeMenuById(Long id);

    /**
     * 修改用户状态
     * @param id 用户id
     * @param status 菜单状态 标识(0 :启用  ,1 :禁用 )
     * @return
     */
    void updateStatus(Long id, Integer status);

    /**
     * 根据角色获取菜单
     * @param roleId 角色id
     * @return
     */
    List<SysMenu> findSysMenuByRoleId(String roleId);

    /**
     * 角色分配权限
     * @param assignMenuVo 分配菜单vo对象
     * @return
     */
    void doAssign(AssginMenuVo assignMenuVo);

    /**
     * 根据用户id查询 菜单权限
     * @param userId
     * @return
     */
    List<RouterVo> getUserMenuRouterList(String userId);

    /**
     * 根据用户id查询 按钮权限
     * @param userId
     * @return
     */
    List<String> getUserMenuButtonList(String userId);
}
