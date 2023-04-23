package com.udacity.pricing;

import com.udacity.pricing.domain.price.Price;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PricingServiceApplicationTests {

	@LocalServerPort
	private int port;
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testGePrice() {
		ResponseEntity<Price> shouldExist = restTemplate.getForEntity("http://localhost:" + port + "/prices/1",Price.class);
		ResponseEntity<Price> shouldNotExist = restTemplate.getForEntity("http://localhost:" + port + "/prices/33",Price.class);

		Assert.assertThat(shouldExist.getStatusCode(),equalTo(HttpStatus.OK));
		Assert.assertThat(shouldNotExist.getStatusCode(),equalTo(HttpStatus.NOT_FOUND));
	}

}
