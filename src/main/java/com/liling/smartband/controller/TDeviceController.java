package com.liling.smartband.controller;

import com.liling.smartband.beans.TDevice;
import com.liling.smartband.dao.TDeviceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/device")
public class TDeviceController {
    @Autowired
    TDeviceDao tDeviceDao;

    @GetMapping
    @ResponseBody
    public List<TDevice> getTDevice(){
        return tDeviceDao.findAll();
    }
}
