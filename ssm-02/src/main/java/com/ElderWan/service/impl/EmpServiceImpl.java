package com.ElderWan.service.impl;

import com.ElderWan.entity.Dept;
import com.ElderWan.entity.Emp;
import com.ElderWan.entity.User;
import com.ElderWan.mapper.DeptMapper;
import com.ElderWan.mapper.EmpMapper;
import com.ElderWan.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Override
    public List<Emp> queryEmps() {
        List<Emp> emps = this.empMapper.queryAll();
        return emps;
    }

    @Override
    public List<Dept> queryDepts() {
        List<Dept> depts = this.deptMapper.qureyAll();
        return depts;
    }

    @Override
    public void add(Emp emp) {

        this.empMapper.insert(emp);
    }

    @Override
    public Emp queryById(Integer id) {
        Emp emp = this.empMapper.getById(id);
        return emp;
    }

    @Override
    public void update(Emp emp) {
        this.empMapper.update(emp);
    }

    @Override
    public void delete(Integer id) {
        this.empMapper.delete(id);
    }
}
