package com.liling.smartband.controller;

import com.baidu.aip.http.AipResponse;
import com.liling.smartband.beans.VoiceResponse;
import com.liling.smartband.service.VoiceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Xiaohui Yang
 * Create at 2019/4/29 13:14
 */

@Slf4j
@Controller
public class VoiceController {

    @Resource
    private VoiceService voiceService;

    private static final String UPLOADED_FOLDER = "src\\main\\resources\\static";

    private static final String SUCCESS_FLAG = "success";
    private static final String FILE_TYPE = "wav";

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        // 1. 上传文件校验
        String fileName = file.getOriginalFilename();
        if (file.isEmpty() || StringUtils.isEmpty(fileName)) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:/result";
        } else if (!FILE_TYPE.equals(fileName.substring(fileName.lastIndexOf(".") + 1))) {
            redirectAttributes.addFlashAttribute("message", "Please upload a .wav file");
            return "redirect:/result";
        }

        // 2. 存储文件为 resources/static 下的 voice.wav
        Path path = null;
        try {
            byte[] bytes = file.getBytes();
            path = Paths.get(UPLOADED_FOLDER + "/voice.wav");
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3. 调用识别
        if (path != null) {
            VoiceResponse response = voiceService.voice2String(path.toString());
            if (response.getErrMsg().contains(SUCCESS_FLAG)) {
                redirectAttributes.addFlashAttribute("message", "语音识别成功，最佳匹配内容为：" +
                        response.getResult().get(0));
            } else {
                redirectAttributes.addFlashAttribute("message", "识别失败，错误信息：" + response.getErrMsg());
            }
        }

        return "redirect:/result";
    }

    @GetMapping("/result")
    public String uploadStatus() {
        return "result";
    }

}
