package com.rumblekat.myhome;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.rumblekat.myhome.Home.HomeDto;
import com.rumblekat.myhome.Home.Item;
import com.rumblekat.myhome.service.DataManager;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
class MyHomeApplicationTests {

    @Autowired
    DataManager dataManager;

    @Value("${service.url}")
    private String url;

    @Value("${service.key}")
    private String key;

    @Test
    void getHome() throws IOException {
        HomeDto home = new HomeDto("202101","202103","01","강원","횡성 벨라시티","0");
        JSONObject response = dataManager.getHome(url, key, home);
        String resultCode = response.getJSONObject("response").getJSONObject("header").get("resultCode").toString();
        assertThat(resultCode , is("00"));
        System.out.println(response.toString());
    }

    @Test
    void getHomeArray() throws IOException {
        HomeDto home = new HomeDto("202101","202112","01","강원","","");
        JSONObject response = dataManager.getHome(url, key, home);
        String json = response.getJSONObject("response").getJSONObject("body").getJSONObject("items").get("item").toString();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        Item[] items = objectMapper.readValue(json, Item[].class);
        Arrays.stream(items).forEach(item -> {
            System.out.println(item);
        });
        /*
        * Java 8 date/time type `java.time.LocalDateTime` not supported by default: add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310"
        * objectMapper.registerModule(new JavaTimeModule());
        * objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        *
        * 어노테이션 추가
        * @DateTimeFormat(pattern = "yyyy-MM-dd")
        * */
    }
}
