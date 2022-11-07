package cn.ww.system.service.impl;

import cn.ww.model.entity.SysUser;
import cn.ww.model.vo.SysRoleQueryVo;
import cn.ww.model.vo.SysUserQueryVo;
import cn.ww.system.mapper.SysUserMapper;
import cn.ww.system.service.SysUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Suww
 * @since 2022-11-03
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    SysUserMapper sysUserMapper;
    
    @Override
    public IPage<SysUser> selectByPage(Page<SysUser> pageParam, SysUserQueryVo sysUser) {
        return sysUserMapper.selectByPage(pageParam,sysUser);
    }
}
