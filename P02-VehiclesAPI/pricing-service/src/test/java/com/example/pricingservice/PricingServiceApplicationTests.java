package com.example.pricingservice;

import com.example.pricingservice.domin.price.Price;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PricingServiceApplicationTests {

    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    public void testGePrice() {
        ResponseEntity<Price> shouldExist = restTemplate.getForEntity("http://localhost:" + port + "/prices/1", Price.class);
        ResponseEntity<Price> shouldNotExist = restTemplate.getForEntity("http://localhost:" + port + "/prices/33", Price.class);

        Assertions.assertEquals(HttpStatus.OK, shouldExist.getStatusCode());
        Assertions.assertEquals(HttpStatus.NOT_FOUND, shouldNotExist.getStatusCode());

    }

}
