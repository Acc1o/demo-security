package cn.ww.system.service;

import cn.ww.model.entity.SysRole;
import cn.ww.model.vo.SysRoleQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
