package com.example;

import com.alibaba.fastjson.JSON;
import com.squareup.okhttp.*;
import org.apache.shiro.crypto.hash.Hash;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TestGaoDe
 * @Decription TODO
 * @Auther mac
 * @Date 2019-08-30 18:11
 * @Version 1.0
 **/
public class TestGaoDe {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://restapi.amap.com/v3/config/district?subdistrict=1&showbiz=false&extensions=all&key=d071998c784bc9aacc90f2e056533385&s=rsv3&output=json&level=district&keywords=440604&callback=jsonp_305770_&platform=JS&logversion=2.0&appname=https%3A%2F%2Flbs.amap.com%2Fapi%2Fjavascript-api%2Fexample%2Fdistrict-search%2Fcity-drop-down-list&csid=9A7EAFBD-28A1-4BBA-86DE-90C828BCDF2B&sdkversion=1.4.15")
                .get()
                .addHeader("User-Agent", "PostmanRuntime/7.15.2")
                .addHeader("Accept", "*/*")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Postman-Token", "09358fe4-ade0-41ff-a991-684958be312a,5f9812ba-9aa8-4205-a7af-826b01fd3371")
                .addHeader("Host", "restapi.amap.com")
                //.addHeader("Accept-Encoding", "gzip, deflate")
                .addHeader("Connection", "keep-alive")
                .addHeader("cache-control", "no-cache")
                .build();
        try {
            Response response = client.newCall(request).execute();
            MediaType mediaType = response.body().contentType();
            System.out.println(mediaType.charset().name());
            System.out.println(mediaType.toString());
            //System.out.println(JSON.toJSONString(response.body().bytes()));
//            System.out.println();
            String s = response.body().string();
            int i = s.lastIndexOf("(");
            int i1 = s.lastIndexOf(")");
            int i2 = s.indexOf("(");
            int i3 = s.indexOf(")");
            String substring = s.substring(i2+1, i3);
            System.out.println(substring);
        } catch (IOException e) {
            e.printStackTrace();
        }


//        Map<String,String> map = new HashMap();
//        map.put("User-Agent","PostmanRuntime/7.15.2");
//        map.put("Accept","*/*");
//        map.put("Cache-Control","no-cache");
//        map.put("Postman-Token","09358fe4-ade0-41ff-a991-684958be312a,5f9812ba-9aa8-4205-a7af-826b01fd3371");
//        map.put("Host","restapi.amap.com");
//        map.put("Accept-Encoding","gzip, deflate");
//        map.put("Connection","keep-alive");
//        map.put("cache-control","no-cache");
//        String url = "https://restapi.amap.com/v3/config/district?subdistrict=1&showbiz=false&extensions=all&key=d071998c784bc9aacc90f2e056533385&s=rsv3&output=json&level=district&keywords=440604&callback=jsonp_305770_&platform=JS&logversion=2.0&appname=https%3A%2F%2Flbs.amap.com%2Fapi%2Fjavascript-api%2Fexample%2Fdistrict-search%2Fcity-drop-down-list&csid=9A7EAFBD-28A1-4BBA-86DE-90C828BCDF2B&sdkversion=1.4.15";
//        String s = HttpUtils.doGetSSLByCookie(url, map, "PHPSESSID", "pefe8o3i4rbcu0q3rnqhbgh6l6", "/", ".lbs.amap.com");
//        System.out.println(s);
    }
}
