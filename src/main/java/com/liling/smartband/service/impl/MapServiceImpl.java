package com.liling.smartband.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.liling.smartband.beans.MapResponse;
import com.liling.smartband.service.MapService;
import com.liling.smartband.util.HttpRequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author Xiaohui Yang
 * Create at 2019/4/29 16:48
 */

@Slf4j
@Component
public class MapServiceImpl implements MapService {

    private static final String SUCCESS_STATUS = "ok";

    @Override
    public MapResponse getLocation(String location) {
        String json = HttpRequestUtil.sendToGetLocation(location);
        Map first = (Map) JSONObject.parse(json);
        Map locationMap = (Map)((Map) first.get("result")).get("location");
        MapResponse response = new MapResponse();
        response.setStatus((int)first.get("status"));
        // lng-经度 lat-纬度
        double lat = ((BigDecimal) locationMap.get("lat")).doubleValue();
        double lng = ((BigDecimal) locationMap.get("lng")).doubleValue();
        double[] arr = {lat, lng};
        response.setLocation(arr);

        return response;
    }

    @Override
    public List<String> getPathPlaning(double[] origin, double[] destination) {
        List<String> list = new java.util.ArrayList<>(Collections.emptyList());
        String json = HttpRequestUtil.sendToPathPlaning(origin, destination);
        Map first = (Map) JSONObject.parse(json);
        log.info("status: {}", first.get("message"));
        if (!SUCCESS_STATUS.equals(first.get("message"))) {
            return list;
        }
        List routes = (List)((Map) first.get("result")).get("routes");
        Map route = (Map) routes.get(0);
        List<Map> steps = (List<Map>) route.get("steps");
        steps.forEach(step -> {
            list.add((String)step.get("instruction"));
        });
        return list;
    }
}
