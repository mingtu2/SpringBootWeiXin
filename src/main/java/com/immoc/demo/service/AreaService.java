package com.immoc.demo.service;

import com.immoc.demo.dao.AreaDao;
import com.immoc.demo.entity.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author mingtu
 * @create 2019/12/7  17:57
 */
@Service
public class AreaService {

    @Autowired
    private AreaDao areaDao;

    public List<Area> queryArea(){
        System.out.println("areaService....");
        return areaDao.queryArea();
    }

    public  Area getAreaById(Integer areaId) {
        System.out.println("service getAreaById...");
        return areaDao.queryAreaById(areaId);
    }

    public boolean addArea(Area area) {
        boolean flag=false;
        if(area==null){
            return flag;
        }
        List<Area> areas = areaDao.queryArea();
        for (int i = 0; i <areas.size() ; i++) {
            try {
                if(area.getAreaName().equals(areas.get(i).getAreaName())){
                    throw new RuntimeException("添加的区域已经存在，请重新添加");
                }
            }catch (Exception e){
                throw new RuntimeException("添加的区域已经存在，请重新添加"+e.getMessage());
            }
        }
        flag = areaDao.addArea(area);
        if(!flag){
            throw new RuntimeException("区域添加失败,请重新添加");
        }
        return flag;
    }

    public boolean updateArea(Area area) {
        System.out.println("areaService updateArea...");
        boolean flag=false;
        area.setUpdateTime(new Date());
        flag= areaDao.updateArea(area);
        if(!flag){
            throw new RuntimeException("更新数据失败");
        }
        return  flag;
    }

    public boolean deleteAreaById(int areaId) {
        boolean flag=false;
        System.out.println("areaService delete...");
        flag= areaDao.deleteAreaById(areaId);
        try {
            if(!flag){
                throw new RuntimeException("数据删除失败");
            }
        }catch (Exception e){
            e.getStackTrace();
            throw new RuntimeException("数据删除失败"+e.getMessage());
        }
        return flag;
    }
}
