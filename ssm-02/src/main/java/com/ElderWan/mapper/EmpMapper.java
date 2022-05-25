package com.ElderWan.mapper;

import com.ElderWan.entity.Emp;

import java.util.List;

public interface EmpMapper {
        List<Emp> queryAll();
        void insert(Emp emp);
        Emp getById(Integer id);
        void update(Emp emp);
        void delete(Integer id);
}
