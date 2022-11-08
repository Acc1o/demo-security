package cn.ww.system.service;

import cn.ww.model.entity.SysRole;
import cn.ww.model.vo.AssginRoleVo;
import cn.ww.model.vo.SysRoleQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * @author Suww
 * @createTime 2022-10-26
 */
public interface SysRoleService extends IService<SysRole> {
    
    /**
     * 条件分页查询
     * @param pageParam 分页参数
     * @param sysRoleQueryVo 查询查询
     * @return
     */
    IPage<SysRole> selectPage(Page<SysRole> pageParam, SysRoleQueryVo sysRoleQueryVo);

    /**
     * 获取用户角色信息
     * @param userId 用户id
     * @return
     */
    Map<String, Object> getRoles(String userId);

    /**
     * 分配用户角色
     * @param assignRoleVo 角色:用户关系表对象
     */
    void doAssign(AssginRoleVo assignRoleVo);
}
