package cn.ww.system.service.impl;

import cn.ww.model.entity.SysRole;
import cn.ww.model.vo.SysRoleQueryVo;
import cn.ww.system.mapper.SysRoleMapper;
import cn.ww.system.service.SysRoleService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Suww
 * @createTime 2022-10-26
 */

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    
    @Override
    public IPage<SysRole> selectPage(Page<SysRole> pageParam, SysRoleQueryVo sysRoleQueryVo) {
        return baseMapper.selectPage(pageParam,sysRoleQueryVo);
    }
}
