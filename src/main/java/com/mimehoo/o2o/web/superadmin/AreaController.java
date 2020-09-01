package com.mimehoo.o2o.web.superadmin;

import com.mimehoo.o2o.entity.Area;
import com.mimehoo.o2o.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/superadmin")
public class AreaController {
    Logger logger = LoggerFactory.getLogger(AreaController.class);
    @Autowired
    private AreaService areaService;

    @RequestMapping("/listarea")
    @ResponseBody
    public Map<String, Object> listArea() {
        logger.info("======start======");
        long startTime = System.currentTimeMillis();
        HashMap<String, Object> modelMap = new HashMap<>();
        List<Area> areas;
        try {
            areas = areaService.getAreaList();
            modelMap.put("rows", areas);
            modelMap.put("total", areas.size());
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errorMsg", e.toString());
        }
        logger.error("test error!");
        long endTime = System.currentTimeMillis();
        logger.debug("costTime:[{}]ms", endTime - startTime);
        logger.info("======end======");
        return modelMap;
    }
}
