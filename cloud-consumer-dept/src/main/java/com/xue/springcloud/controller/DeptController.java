package com.xue.springcloud.controller;

import com.xue.springcloud.client.DeptServiceClient;
import com.xue.springcloud.client.DeptServiceClientFallbackFactory;
import com.xue.springcloud.entity.DeptDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 消费者部门控制器
 *
 * @author ：HUANG ZHI XUE
 * @date ：Create in 2020-10-20
 */
@RestController
public class DeptController {

    private final static String URL = "http://cloud-provider-dept";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DeptServiceClient deptServiceClient;

    /*@ResponseBody
    @RequestMapping(value = "/listDeptInfo")
    public List<DeptDO> deptDOListInfo() {
        return restTemplate.getForObject(URL + "/listDeptInfo", List.class);
    }
 */
    //采用Feign调用
    @ResponseBody
    @RequestMapping(value = "/listDeptInfo")
    public List<DeptDO> deptDOListInfo() {
        return deptServiceClient.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/listDeptInfo2/{id}")
    public DeptDO deptDOListInfo(@PathVariable("id") Long id) {
        return deptServiceClient.getDept2(id);
    }
}
