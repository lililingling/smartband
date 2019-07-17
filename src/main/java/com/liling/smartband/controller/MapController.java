package com.liling.smartband.controller;

import com.liling.smartband.beans.MapResponse;
import com.liling.smartband.service.MapService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Xiaohui Yang
 * Create at 2019/4/29 16:35
 */

@Slf4j
@Controller
public class MapController {

    private double[] origin = {30.835667D, 104.190605D};

    public void setOrigin(double[] origin) {
        this.origin = origin;
    }

    @Resource
    private MapService mapService;

    @PostMapping("/path")
    public String getPath(@RequestParam("locationName") String locationName,
                          RedirectAttributes redirectAttributes) {
        MapResponse response = mapService.getLocation(locationName);
        log.info("目的地：{}，纬度：{}，经度：{}", locationName, response.getLocation()[0], response.getLocation()[1]);
        List<String> list = mapService.getPathPlaning(origin, response.getLocation());

        log.info("请求成功，结果为：{}", list);
        redirectAttributes.addFlashAttribute("origin", "西南石油大学西门");
        redirectAttributes.addFlashAttribute("destination", locationName);
        redirectAttributes.addFlashAttribute("list", list);

        return "redirect:/list";
    }

    @GetMapping("/list")
    public String returnList() {
        return "list";
    }
}
