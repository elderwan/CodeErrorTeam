package com.ElderWan.controller;

import com.ElderWan.entity.Dept;
import com.ElderWan.entity.Emp;
import com.ElderWan.service.EmpService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping("/emp/emps")
    public String queryEmps(Map map) {
        List<Emp> emps = this.empService.queryEmps();
        map.put("emps", emps);
        return "emp/list";
    }
    @RequiresPermissions("emp:add")
    @GetMapping("/emp/preAdd")
    public String toAdd(Map map) {
        List<Dept> depts = this.empService.queryDepts();
        map.put("depts",depts);
        return "emp/add";

    }
    @RequiresPermissions("emp:add")
    @PostMapping("/emp/emp")
    public String add(Emp emp) {
        System.out.println(emp);
        emp.setStatus(1);
        this.empService.add(emp);
        return "redirect:emps";
    }

    @RequiresPermissions("emp:update")
    @GetMapping ("/emp/{id}")
    public String preEdit(@PathVariable("id") Integer id,Map map) {
        System.out.println("--------------->"+id);
        Emp emp = this.empService.queryById(id);
        List<Dept> depts = this.empService.queryDepts();
        map.put("emp",emp);
        map.put("depts",depts);
        return "emp/edit";
    }
    @RequiresPermissions("emp:update")
    @PutMapping ("/emp/edit")
    public String edit(Emp emp) {
        System.out.println(emp);
        emp.setStatus(1);
        this.empService.update(emp);
        return "redirect:emps";
    }
    @RequiresPermissions("emp:del")
    @DeleteMapping  ("/emp/del")
    public String del(Integer id) {
        System.out.println("============>删除的id"+id);
        this.empService.delete(id);
        return "redirect:emps";
    }
}
