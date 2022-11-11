package cn.ww.system.mapper;


import cn.ww.model.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Suww
 * @since 2022-11-09
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 根据用户id查询菜单权限数据
     * @param userId 用户id
     * @return
     */
    List<SysMenu> getMenuListUserId(@Param("userId") String userId);
}
