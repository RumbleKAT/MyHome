package com.rumblekat.myhome;

import com.rumblekat.myhome.Home.HomeDto;
import com.rumblekat.myhome.service.DataManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

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
        System.out.println(dataManager.getHome(url, key, home));
    }

}
