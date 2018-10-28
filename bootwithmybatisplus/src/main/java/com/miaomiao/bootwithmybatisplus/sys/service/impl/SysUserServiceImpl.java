package com.miaomiao.bootwithmybatisplus.sys.service.impl;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.miaomiao.bootwithmybatisplus.common.utils.JsonResulte;
import com.miaomiao.bootwithmybatisplus.common.utils.PageUtils;
import com.miaomiao.bootwithmybatisplus.sys.entity.SysUser;
import com.miaomiao.bootwithmybatisplus.sys.mapper.SysUserMapper;
import com.miaomiao.bootwithmybatisplus.sys.service.ISysUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author miaomiao
 * @since 2018-10-28
 */
@Service
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

@Resource
    private SysUserMapper sysUserMapper;

    /**
     *  分页测试
     * @param psize 页面大小
     * @param pnum 页码
     * @param type 类型  分页类型  1 ：使用EntityWrapper分页  2 ：使用Condition分页  3：使用分页插件
     * @return
     */
    @Override
    public JsonResulte findPage(String pnum, String psize, String type) {
        log.info("findPage  psize:{}. pnum:{}. type:{}. ",new String[]{psize, pnum,type});
        Map<String,Object> re=new HashMap<String, Object>();
        Page<SysUser> page =new Page<SysUser>();
        page.setSize(Integer.valueOf(psize));
        page.setCurrent(Integer.valueOf(pnum));
        List<SysUser> ls =new ArrayList<SysUser>();
        switch (type){
            case "1":
                log.info("    使用EntityWrapper分页 ");
                ls=  sysUserMapper.selectPage(page,new EntityWrapper<SysUser>().eq("username","admin"));
                break;
            case "2":
                log.info("    使用Condition分页 ");
                ls=sysUserMapper.selectPage(page, Condition.create().eq("username","admin"));
                break;
            case"3":
                log.info("    使用分页插件 ");
                ls=sysUserMapper.selectPageVo(page,"admin");
                break;
            default:
                break;
        }
        page.setRecords(ls);
        PageUtils utils=new PageUtils(page);

        re.put("page",utils);

        return  JsonResulte.ok(re);
    }

}
