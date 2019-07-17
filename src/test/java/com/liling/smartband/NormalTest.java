package com.liling.smartband;

import com.liling.smartband.service.impl.MapServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Xiaohui Yang
 * Create at 2019/4/29 17:07
 */

@Slf4j
public class NormalTest {

    @Test
    public void locationTest() {
        MapServiceImpl service = new MapServiceImpl();
        log.info("{}", service.getLocation("钟楼"));
    }

    @Test
    public void pathTest() {
        MapServiceImpl service = new MapServiceImpl();
        double[] origin = {30.831116D, 104.188849D};
        double[] des = {30.805678109999D, 104.20074422109D};
        log.info("{}", service.getPathPlaning(origin, des));
    }
}
