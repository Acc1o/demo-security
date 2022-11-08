package cn.ww.system.service.impl;

import cn.ww.model.entity.SysUser;
import cn.ww.model.vo.SysUserQueryVo;
import cn.ww.system.mapper.SysUserMapper;
import cn.ww.system.service.SysUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
    
    @Override
    public IPage<SysUser> selectByPage(Page<SysUser> pageParam, SysUserQueryVo sysUserQueryVo) {
        return baseMapper.selectByPage(pageParam,sysUserQueryVo);
    }

    @Override
    public void updateStatus(Long id, Integer status) {
        SysUser sysUser = baseMapper.selectById(id);
        sysUser.setStatus(status);
        baseMapper.updateById(sysUser);
    }
}   
