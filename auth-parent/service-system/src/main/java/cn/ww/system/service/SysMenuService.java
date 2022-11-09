package cn.ww.system.service;


import cn.ww.model.entity.SysMenu;
import cn.ww.model.vo.AssginMenuVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author Suww
 * @since 2022-11-09
 */
public interface SysMenuService extends IService<SysMenu> {

    List<SysMenu> findNodes();

    void removeMenuById(Long id);

    void updateStatus(Long id, Integer status);

    List<SysMenu> findSysMenuByRoleId(String roleId);
 
    void doAssign(AssginMenuVo assginMenuVo);
}
