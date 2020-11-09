package com.xue.springcloud.service.impl;

import com.xue.springcloud.entity.DeptDO;
import com.xue.springcloud.mybatis.dao.DeptDao;
import com.xue.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ServiceImpl:DeptServiceImpl
 * @author
 * @date 2020-10-20
 */
@Transactional(rollbackFor = Exception.class)
@Service("deptService") 
public class DeptServiceImpl implements DeptService {
	
    @Autowired
    private DeptDao deptDao;

    @Override
    public int insert(DeptDO deptDO) {
        return 0;
    }

    @Override
    public int update(DeptDO deptDO) {
        return 0;
    }

    @Override
    public int delete(String deptno) {
        return 0;
    }

    @Override
    public List<DeptDO> findList(DeptDO deptDO) {
        return deptDao.findList(deptDO);
    }

    @Override
    public List<DeptDO> findAll() {
        return deptDao.findAll();
    }

    @Override
    public DeptDO getDept(Long id) {
        if (id == 1) {
            return new DeptDO();
        } else if (id == 2) {
            return new DeptDO();
        }
        return null;
    }
}