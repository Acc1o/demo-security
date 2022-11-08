package cn.ww.system.service;

import cn.ww.model.entity.SysUser;
import cn.ww.model.vo.SysUserQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Suww
 * @since 2022-11-03
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 条件分页查询
     * @param pageParam 分页参数
     * @param sysUserQueryVo 查询查询
     * @return
     */
    IPage<SysUser> selectByPage(Page<SysUser> pageParam, SysUserQueryVo sysUserQueryVo);

    /**
     * 修改用户状态
     * @param id 用户id
     * @param status 用户状态 标识(0 :启用  ,1 :禁用 )
     */
    void updateStatus(Long id, Integer status);
}
