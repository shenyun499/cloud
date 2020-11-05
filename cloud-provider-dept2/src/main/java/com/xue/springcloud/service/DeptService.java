package com.xue.springcloud.service;

import com.xue.springcloud.entity.DeptDO;

import java.util.List;

/**
 * Service Interface:DeptService
 * @author
 * @date 2020-10-20
 */
public interface DeptService {

    int insert(DeptDO deptDO);

    int update(DeptDO deptDO);

    int delete(String deptno);

    List<DeptDO> findList(DeptDO deptDO);


    /**
     * 查询所有部分信息
     *
     * @return
     */
    List<DeptDO> findAll();

}