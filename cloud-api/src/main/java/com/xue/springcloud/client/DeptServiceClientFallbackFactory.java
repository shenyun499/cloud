package com.xue.springcloud.client;

import com.xue.springcloud.entity.DeptDO;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 熔断方法
 *
 * @author ：HUANG ZHI XUE
 * @date ：Create in 2020-11-04
 */
@Component
public class DeptServiceClientFallbackFactory implements FallbackFactory<DeptServiceClient> {
    @Override
    public DeptServiceClient create(Throwable throwable) {
        return new DeptServiceClient() {
            @Override
            public List<DeptDO> findAll() {
                DeptDO deptDO = new DeptDO();
                deptDO.setDeptno(3L);
                deptDO.setDname("信息不存在");
                deptDO.setDbSource("no record in database");
                List<DeptDO> list = new ArrayList<>();
                list.add(deptDO);
                return list;
            }

            @Override
            public DeptDO getDept2(Long id) {
                DeptDO deptDO = new DeptDO();
                deptDO.setDeptno(id);
                deptDO.setDname("信息不存在");
                deptDO.setDbSource("no record in database");
                return deptDO;
            }
        };

    }
}
