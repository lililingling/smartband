package com.liling.smartband.service.impl;

import com.alibaba.fastjson.JSON;
import com.baidu.aip.http.AipResponse;
import com.baidu.aip.speech.AipSpeech;
import com.liling.smartband.beans.VoiceResponse;
import com.liling.smartband.service.VoiceService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Xiaohui Yang
 * Create at 2019/4/29 13:15
 */

@Slf4j
@Component
public class VoiceServiceImpl implements VoiceService {

    private static final String APP_ID = "16065541";

    private static final String API_KEY = "mDtj7RYrPKRXz0F61jjOg2QZ";

    private static final String SECRET_KEY = "wRoX5NSZEjxyXGeR9RBsTakGNvf1utAD";

    private AipSpeech client;

    public VoiceServiceImpl() {
        // 初始化一个AipSpeech
        client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
    }

    @Override
    public VoiceResponse voice2String(String path) {
        JSONObject res = client.asr(path, "wav", 16000, null);
        VoiceResponse response = JSON.parseObject(res.toString(), VoiceResponse.class);
        log.info("result: {}, errorMsg: {}", response.getResult(), response.getErrMsg());
        return response;
    }
}
