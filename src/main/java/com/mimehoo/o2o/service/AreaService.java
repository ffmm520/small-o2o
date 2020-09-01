package com.mimehoo.o2o.service;

import com.mimehoo.o2o.dao.AreaDao;
import com.mimehoo.o2o.entity.Area;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface AreaService {
    List<Area> getAreaList();
}
