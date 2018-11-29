package com.jett.springcloud.controller;

import com.jett.springcloud.entities.Dept;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.jett.springcloud.biz.service.DeptService;


import java.util.List;

@RestController
@RequestMapping("/dept")
@Api(tags="部门API")
@Slf4j
public class DeptController {
    @Autowired
    private DeptService service;

//    @RequestMapping(value="/dept/add",method=RequestMethod.POST)
    @PostMapping("/add")
    @ApiOperation(value="添加部门")
    @ApiImplicitParam(name = "dept", value = "部门详细实体user", required = true, dataType = "Dept")
    public boolean add(@RequestBody Dept dept)
    {
        log.info("Add department information");
        return service.add(dept);
    }

//    @RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
    @GetMapping("/get/{id}")
    @ApiOperation(value="根据ID获取指定部门")
    @ApiImplicitParam(name = "id", value = "部门Id", required = true, dataType = "Long")
    public Dept get(@PathVariable("id") Long id)
    {
        log.info("Get department information");
        return service.get(id);
    }

//    @RequestMapping(value="/dept/list",method= RequestMethod.GET)
    @GetMapping(value = {"/list",""})
    @ApiOperation(value="获取全部部门信息")
    public List<Dept> list()
    {
        log.info("List department information");
        return service.list();
    }
}
