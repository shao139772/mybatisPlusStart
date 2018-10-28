package com.miaomiao.bootwithmybatisplus.sys.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.miaomiao.bootwithmybatisplus.sys.entity.SysUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 系统用户 Mapper 接口
 * </p>
 *
 * @author miaomiao
 * @since 2018-10-29
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * <p>
     * 查询 : 根据username状态查询用户列表，分页显示
     * 注意!!: 如果入参是有多个,需要加注解指定参数名才能在xml中取值
     * </p>
     *
     * @param page 分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位(你可以继承Page实现自己的分页对象)
     * @param username 用户名
     * @return 分页对象
     */
    List<SysUser> selectPageVo(Page page, @Param("username") String username);


}
