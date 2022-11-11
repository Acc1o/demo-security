package cn.ww.system.service.impl;

import cn.ww.model.entity.SysUser;
import cn.ww.model.vo.RouterVo;
import cn.ww.model.vo.SysUserQueryVo;
import cn.ww.system.mapper.SysUserMapper;
import cn.ww.system.service.SysMenuService;
import cn.ww.system.service.SysUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

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
    
    @Resource
    private SysMenuService sysMenuService;
    
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

    @Override
    public SysUser getUserInfoByUserName(String username) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public Map<String, Object> getUserInfo(String username) {
        SysUser sysUser = this.getUserInfoByUserName(username);
        List<RouterVo> routerList= sysMenuService.getUserMenuRouterList(sysUser.getId());
        List<String> buttonList=  sysMenuService.getUserMenuButtonList(sysUser.getId());
        
        HashMap<String, Object> result = new HashMap<>();
        result.put("name",username);
        result.put("avatar","https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg");
        result.put("roles",  new HashSet<>());
        result.put("routers", routerList);
        result.put("buttons", buttonList);
        return result;
    }
}   
