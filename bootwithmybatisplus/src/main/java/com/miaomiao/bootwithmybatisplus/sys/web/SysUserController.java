package com.miaomiao.bootwithmybatisplus.sys.web;


import com.miaomiao.bootwithmybatisplus.common.utils.JsonResulte;
import com.miaomiao.bootwithmybatisplus.sys.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 系统用户 前端控制器
 * </p>
 *
 * @author miaomiao
 * @since 2018-10-28
 */
@Controller
@RequestMapping("/sys/sysUser")
@Slf4j
public class SysUserController {


    @Autowired
    private ISysUserService iSysUserService;


    /**
     *  分页测试
     * @param psize 页面大小
     * @param pnum 页码
     * @param type 类型  分页类型  1 ：使用EntityWrapper分页  2 ：使用Condition分页  3：使用分页插件
     * @return
     */
    @RequestMapping(value = "/findPage/{pnum}/{psize}/{type}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResulte findAll(@PathVariable("psize")String psize, @PathVariable("pnum")String pnum, @PathVariable("type")String type) {
        return iSysUserService.findPage(pnum,psize,type);
    }

}

