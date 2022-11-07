package cn.ww.system.mapper;

import cn.ww.model.entity.SysRole;
import cn.ww.model.vo.SysRoleQueryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Suww
 * @createTime 2022-10-26
 */
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {
    
    IPage<SysRole> selectPage(Page<SysRole> pageParam,@Param("vo") SysRoleQueryVo sysRoleQueryVo);
}
