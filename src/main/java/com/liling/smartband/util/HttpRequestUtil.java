package com.liling.smartband.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.MessageFormat;

/**
 * @author Xiaohui Yang
 * Create at 2019/4/29 16:52
 */

@Slf4j
public class HttpRequestUtil {

    private static final String USER_AGENT = "Mozilla/5.0";

    private static final String AK = "8eubuakGM119G47tcsYvOmoGTlQQtERv";

    public static String sendToGetLocation(String location)  {
        String url = MessageFormat.format("http://api.map.baidu.com/geocoder/v2/?address={0}&output=json&" +
                "ak={1}", location, AK);
        return sendRequest(url);
    }

    public static String sendToPathPlaning(double[] origin, double[] destination) {
        String url = MessageFormat.format("http://api.map.baidu.com/directionlite/v1/walking?origin={0},{1}" +
                "&destination={2},{3}&ak={4}", origin[0], origin[1], destination[0], destination[1], AK);
        return sendRequest(url);
    }

    private static String sendRequest(String url) {
        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", USER_AGENT);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } catch (Exception e) {
            log.error("send message error. {}", ExceptionUtils.getStackTrace(e));
        }

        return StringUtils.EMPTY;
    }

}
