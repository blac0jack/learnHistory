package com.jyc.website.Controller;

import org.junit.Test;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/**
 * 测试控制器
 *
 * @author: @我没有三颗心脏
 * @create: 2018-05-08-下午 16:46
 */
@RestController
public class IndexController {

    @RequestMapping("/hello")
    public String hello() {
        return "2019-06-25 docker 自动部署成功";
    }

    @RequestMapping("/log")
    public String test(HttpServletResponse httpServletResponse){
        ServletOutputStream outputStream = null;
        InputStream decryptInputStream = getInputStream();
        try{
            httpServletResponse.reset();
            httpServletResponse.setContentType("application/json;charset=utf-8");
            outputStream = httpServletResponse.getOutputStream();
            // 在http响应中输出流
            byte[] cache = new byte[1024];
            int nRead = 0;
            while ((nRead = decryptInputStream.read(cache)) != -1) {
                outputStream.write(cache, 0, nRead);
                outputStream.flush();
            }
            outputStream.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static InputStream getInputStream() {
        InputStream inputStream = null;
        HttpURLConnection httpURLConnection = null;
        try {
            URL url = new URL("https://raw.githubusercontent.com/blac0jack/learnHistory/master/%E6%97%A5%E5%BF%97%E8%AE%B0%E5%BD%95.txt");
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("GET");
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                inputStream = httpURLConnection.getInputStream();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return inputStream;
    }
}