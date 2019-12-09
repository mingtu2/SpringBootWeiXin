package com.immoc.demo.dao;

import com.immoc.demo.entity.Area;

import java.util.List;

/**
 * @author mingtu
 * @create 2019/12/7  17:48
 */
public interface AreaDao {
    //查询所有
    List<Area> queryArea();

    //根据id查询对象
    Area queryAreaById(int areaIa);

    //添加一个对象
    boolean addArea(Area area);

    //删除一个对象
    boolean deleteAreaById(int areaId);

    boolean updateArea(Area area);
}
