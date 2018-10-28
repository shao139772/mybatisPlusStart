package com.miaomiao.bootwithmybatisplus.sys.service;

import com.miaomiao.bootwithmybatisplus.common.utils.JsonResulte;
import com.miaomiao.bootwithmybatisplus.sys.entity.SysUser;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author miaomiao
 * @since 2018-10-28
 */
public interface ISysUserService extends IService<SysUser> {

    /**
     *  分页测试
     * @param psize 页面大小
     * @param pnum 页码
     * @param type 类型  分页类型  1 ：使用EntityWrapper分页  2 ：使用Condition分页  3：使用分页插件
     * @return
     */
    JsonResulte findPage(String pnum, String psize, String type);
}
