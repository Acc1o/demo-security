package cn.ww.system.controller;


import cn.ww.common.result.Result;
import cn.ww.model.entity.SysMenu;
import cn.ww.model.vo.AssginMenuVo;
import cn.ww.system.service.SysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

 /**
 * @author Suww
 * @since 2022-11-09
 */

@Api(tags = "菜单管理")
@RestController
@RequestMapping("/admin/system/sysMenu")
public class SysMenuController {

     @Resource
    private SysMenuService sysMenuService;

    /**
     * 菜单列表
     * @return
     */
    @ApiOperation("菜单列表")
    @GetMapping("findNodes")
    public Result findNodes(){
        List<SysMenu> list= sysMenuService.findNodes();
        return Result.ok(list);
    }

    /**
     * 添加菜单
     * @param sysMenu entity对象
     * @return
     */
    @ApiOperation("添加菜单")
    @PostMapping("save")
    public Result save(@RequestBody SysMenu sysMenu){
        sysMenuService.save(sysMenu);
        return Result.ok();
    }

    /**
     * 根据ID查询菜单
     * @param id 菜单id
     * @return
     */
    @ApiOperation("根据ID查询菜单")
    @GetMapping("findNode/{id}")
    public Result findNode(@PathVariable Long id){
        SysMenu sysMenu = sysMenuService.getById(id);
        return Result.ok(sysMenu);
    }

    /**
     * 修改菜单
     * @param sysMenu entity对象
     * @return
     */
    @ApiOperation("修改菜单")
    @PostMapping("update")
    public Result update(@RequestBody SysMenu sysMenu){
        sysMenuService.updateById(sysMenu);
        return Result.ok();
    }

    /**
     * 删除菜单
     * @param id 菜单id
     * @return
     */
    @ApiOperation("删除菜单")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id){
        sysMenuService.removeMenuById(id);
        return Result.ok();
    }

    /**
     * 修改用户状态
     * @param id 用户id
     * @param status 菜单状态 标识(0 :启用  ,1 :禁用 )
     * @return
     */
    @ApiOperation(value = "修改状态")
    @GetMapping("updateStatus/{id}/{status}")
    public Result updateStatus(@PathVariable Long id, @PathVariable Integer status) {
        sysMenuService.updateStatus(id, status);
        return Result.ok();
    }

    /**
     * 根据角色获取菜单
     * @param roleId 角色id
     * @return
     */
    @ApiOperation(value = "根据角色获取菜单")
    @GetMapping("/toAssign/{roleId}")
    public Result toAssign(@PathVariable String roleId) {
        List<SysMenu> list = sysMenuService.findSysMenuByRoleId(roleId);
        return Result.ok(list);
    }

    /**
     * 角色分配权限
     * @param assignMenuVo 分配菜单vo对象
     * @return
     */
    @ApiOperation(value = "给角色分配权限")
    @PostMapping("/doAssign")
    public Result doAssign(@RequestBody AssginMenuVo assignMenuVo) {
        sysMenuService.doAssign(assignMenuVo);
        return Result.ok();
    }

}

