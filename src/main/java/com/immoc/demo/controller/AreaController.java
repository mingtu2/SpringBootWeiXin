package com.immoc.demo.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.immoc.demo.entity.Area;
import com.immoc.demo.service.AreaService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mingtu
 * @create 2019/12/7  17:56
 */
//RestController是controller与responseBody的组合
@RestController
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping("/queryArea")
    public Map<String,Object> queryArea(){
        System.out.println("areaConroller  queryArea..");
        Map<String,Object> map=new HashMap<>();
        List<Area> areaList = areaService.queryArea();
        if(areaList.size()!=0){
            for (int i = 0; i <areaList.size() ; i++) {
                System.out.println(areaList.get(i).getAreaName());
            }
        }
        map.put("areaList",areaList);
        return map;
    }

    @RequestMapping("/getAreaById")
    public Map<String,Object> getAreaById(@RequestParam(value="areaId") int areaId){
        Map<String,Object> map=new HashMap<>();
        System.out.println("areaController getAreaById...");
        Area area=areaService.getAreaById(areaId);
        if(area==null){
            try {
                throw new Exception("没有结果返回,请重新输入参数");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        map.put("area",area);
        return map;
    }

    @RequestMapping("/addArea")
    public Map<String,Object> addArea(@RequestBody Area area){
        System.out.println("controller addArea...");
        Map<String,Object> map=new HashMap<>();
        boolean flag=false;
        flag= areaService.addArea(area);
        map.put("msg",flag);
        return map;
    }

    //@RequestBody Area area把请求的标单数据字符串转换为指定的对象
    @RequestMapping("/updateArea")
    public Map<String,Object> updateArea(@RequestBody Area area){
        System.out.println("controller updateArea...");
        Map<String,Object> map=new HashMap<>();
        boolean flag=false;
        flag= areaService.updateArea(area);
        map.put("msg",flag);
        return map;
    }
    @RequestMapping("/deleteArea")
    public Map<String,Object> deleteAreaById(@RequestParam(value="areaId",required = true) int areaId){
        System.out.println("controller deleteArea...");
        Map<String,Object> map=new HashMap<>();
        boolean flag=false;

        flag= areaService.deleteAreaById(areaId);
        String msg="";
        if (flag){
            msg="数据删除成功";
        }else {
            msg="数据删除失败，请检查更新的参数";
        }
        map.put("msg",msg);
        return map;
    }

}
