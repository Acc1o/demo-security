package cn.ww.system.service;

import cn.ww.model.entity.SysUser;
import cn.ww.model.vo.SysRoleQueryVo;
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

    //用户列表
    IPage<SysUser> selectByPage(Page<SysUser> pageParam, SysUserQueryVo sysUser);
}
