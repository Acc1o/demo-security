package cn.ww.system.service;

import cn.ww.model.entity.SysUser;
import cn.ww.model.vo.SysUserQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
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

    /**
     * 根据用户名称查询用户信息
     * @param username 用户名称
     * @return
     */
    SysUser getUserInfoByUserName(String username);

    /**
     * 根据用户名称查询用户信息
     * @param username 用户名称
     * @return
     */
    Map<String, Object> getUserInfo(String username);
}
