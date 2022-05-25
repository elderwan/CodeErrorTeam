package com.ElderWan.service;

import com.ElderWan.entity.Dept;
import com.ElderWan.entity.Emp;
import com.ElderWan.entity.User;

import java.util.List;

public interface EmpService {
    List<Emp> queryEmps();
    List<Dept> queryDepts();
    void add(Emp emp);
    Emp queryById(Integer id);
    void update(Emp emp);
    void delete(Integer id);
}
