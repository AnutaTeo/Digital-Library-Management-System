package com.dlms.borrowingservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.web.client.RestTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;


import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;


import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {
                "spring.rabbitmq.listener.simple.auto-startup=false"
        }
)
class BorrowingControllerTest {

    @Autowired
    private TestRestTemplate restTemplateTest;

    @MockitoBean
    private RestTemplate restTemplate;

    @MockitoBean
    private RabbitTemplate rabbitTemplate;

    @Test
    void shouldBorrowBook() {

        // Mock user-service response
        when(restTemplate.getForObject(anyString(), eq(Boolean.class)))
                .thenReturn(true);


        Map<String, Object> request = new HashMap<>();
        request.put("userId", 1);
        request.put("bookId", 10);

        ResponseEntity<String> response =
                restTemplateTest.postForEntity("/borrow", request, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
