package com.rumblekat.myhome.service;

import com.rumblekat.myhome.Home.HomeDto;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@Service
public class DataManager {

    public String getHome(String serviceUrl, String serviceKey, HomeDto homeDto) throws IOException {
        StringBuilder urlBuilder = new StringBuilder(serviceUrl); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + serviceKey); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("startmonth","UTF-8") + "=" + URLEncoder.encode(homeDto.getStartDt(), "UTF-8")); /*월 단위 모집공고일 (검색시작월)*/
        urlBuilder.append("&" + URLEncoder.encode("endmonth","UTF-8") + "=" + URLEncoder.encode(homeDto.getEndDt(), "UTF-8")); /*월 단위 모집공고일 (검색종료월, 최대 12개월)*/
        urlBuilder.append("&" + URLEncoder.encode("houseSecd","UTF-8") + "=" + URLEncoder.encode(homeDto.getHouseSecd(), "UTF-8")); /*주택구분*/
        urlBuilder.append("&" + URLEncoder.encode("sido","UTF-8") + "=" + URLEncoder.encode(homeDto.getSido(), "UTF-8")); /*공급지역*/
        urlBuilder.append("&" + URLEncoder.encode("houseName","UTF-8") + "=" + URLEncoder.encode(homeDto.getHouseName(), "UTF-8")); /*주택명*/
        urlBuilder.append("&" + URLEncoder.encode("rentSecd","UTF-8") + "=" + URLEncoder.encode(homeDto.getRentSecd(), "UTF-8")); /*분양/임대 구분값*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        return sb.toString();
    }

}
