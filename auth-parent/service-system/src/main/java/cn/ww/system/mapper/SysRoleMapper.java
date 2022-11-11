package cn.ww.system.mapper;

import cn.ww.model.entity.SysRole;
import cn.ww.model.vo.SysRoleQueryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Suww
 * @createTime 2022-10-26
 */
@Repository
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {


    /**
     * 条件分页查询
     * @param pageParam 分页参数
     * @param sysRoleQueryVo entity查询对象
     * @return
     */
    IPage<SysRole> selectPage(Page<SysRole> pageParam,@Param("vo") SysRoleQueryVo sysRoleQueryVo);
}
