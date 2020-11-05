package com.xue.springcloud.client;

import com.xue.springcloud.entity.DeptDO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Feign 为外提供接口
 *
 * @author ：HUANG ZHI XUE
 * @date ：Create in 2020-10-25
 */
@FeignClient(value = "cloud-provider-dept", fallbackFactory = DeptServiceClientFallbackFactory.class)
public interface DeptServiceClient {

    @RequestMapping(value = "/listDeptInfo")
    List<DeptDO> findAll();

    @RequestMapping(value = "/getDeptInfo2/{id}")
    DeptDO getDept2(@PathVariable("id") Long id);
}
