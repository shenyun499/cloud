package com.xue.springcloud.controller;

import com.xue.springcloud.entity.DeptDO;
import com.xue.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/listDeptInfo")
    public List<DeptDO> findAll() {
        System.out.println("ss");
        return deptService.findAll();
    }
}
