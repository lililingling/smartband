package com.liling.smartband.beans;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author Xiaohui Yang
 * Create at 2019/4/29 16:27
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapResponse {

    /** 0 代表成功 */
    private int status;

    /** 经纬度 1-经度 0-纬度 */
    private double[] location;



}
