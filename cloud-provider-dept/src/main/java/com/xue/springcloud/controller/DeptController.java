package com.xue.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xue.springcloud.entity.DeptDO;
import com.xue.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 部门操作控制器
 *
 * @author ：HUANG ZHI XUE
 * @date ：Create in 2020-10-20
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @ResponseBody
    @RequestMapping(value = "/listDeptInfo")
    public List<DeptDO> findAll() {
        List<DeptDO> listDeptDO = new ArrayList<>();
        DeptDO deptDO = new DeptDO();
        deptDO.setDname("dept");
        listDeptDO.add(deptDO);
        return listDeptDO;
    }

    @ResponseBody
    @RequestMapping(value = "/getDeptInfo/{id}")
    //一旦错误方法抛出异常信息，会自动调用
    @HystrixCommand(fallbackMethod = "getDeptError")
    public DeptDO getDept(@PathVariable("id") Long id) {
        DeptDO deptDO = deptService.getDept(id);
        if (deptDO == null) {
            throw new RuntimeException();
        }
        return deptDO;
    }

    public DeptDO getDeptError(@PathVariable("id") Long id) {
        DeptDO deptDO = new DeptDO();
        deptDO.setDeptno(id);
        deptDO.setDname("信息不存在");
        deptDO.setDbSource("no record in database");
        return deptDO;
    }

    @ResponseBody
    @RequestMapping(value = "/getDeptInfo2/{id}")
    public DeptDO getDept2(@PathVariable("id") Long id) {
        DeptDO deptDO = deptService.getDept(id);
        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (deptDO == null) {
            throw new RuntimeException();
        }*/
        return deptDO;
    }

    /*@ResponseBody
    @RequestMapping(value = "/listDeptInfo")
    public DeptDO findAll() {
        return deptService.findList(new DeptDO());
    }*/
}
