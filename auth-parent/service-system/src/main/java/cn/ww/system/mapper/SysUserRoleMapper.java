package cn.ww.system.mapper;

import cn.ww.model.entity.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Suww
 * @createTime 2022-11-08
 */

@Repository
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
    
}
