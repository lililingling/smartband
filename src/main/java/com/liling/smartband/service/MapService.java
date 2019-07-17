package com.liling.smartband.service;

import com.liling.smartband.beans.MapResponse;

import java.util.List;

/**
 * @author Xiaohui Yang
 * Create at 2019/4/29 16:26
 */

public interface MapService {

    /**
     * 获取某地点经纬度
     *
     * @param location 地名
     * @return 地址结果
     */
    MapResponse getLocation(String location);

    /**
     * 步行的路径规划
     *
     * @param origin 起点经纬度
     * @param destination 终点经纬度
     * @return 按顺序是步行的走法
     */
    List<String> getPathPlaning(double[] origin, double[] destination);

}
