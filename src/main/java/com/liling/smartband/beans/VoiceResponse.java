package com.liling.smartband.beans;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Xiaohui Yang
 * Create at 2019/4/29 15:44
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoiceResponse {

    /** 错误号，调试用 */
    @JSONField(name = "err_no")
    private int errNo;

    /** 错误信息，成功为 success. */
    @JSONField(name = "err_msg")
    private String errMsg;

    /** 序列号，调试用 */
    private String sn;

    /** 识别结果为一个大小不超过 5 的数组，根据匹配程度排序 */
    private List<String> result;

}
