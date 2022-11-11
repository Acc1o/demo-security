package cn.ww.system.mapper;

import cn.ww.model.entity.SysUser;
import cn.ww.model.vo.SysUserQueryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Suww
 * @since 2022-11-03
 */
@Repository
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 条件分页查询
     * @param pageParam 分页参数
     * @param sysUserQueryVo entity查询对象
     * @return
     */
    IPage<SysUser> selectByPage(Page<SysUser> pageParam,@Param("vo") SysUserQueryVo sysUserQueryVo);

}
