package com.liling.smartband.service;


import com.liling.smartband.beans.VoiceResponse;

/**
 * @author Xiaohui Yang
 * Create at 2019/4/29 13:15
 */

public interface VoiceService {

    /**
     * wav 文件语音识别
     * @param path 文件存储路径
     * @return 识别结果
     */
    VoiceResponse voice2String(String path);
}
