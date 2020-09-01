package com.mimehoo.o2o.service;

import com.mimehoo.o2o.BaseTest;
import com.mimehoo.o2o.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AreaServiceTest extends BaseTest {
    @Autowired
    private AreaService areaService;

    @Test
    public void testAreaTest() {
        List<Area> areaList = areaService.getAreaList();
        System.out.println(areaList);
    }
}
