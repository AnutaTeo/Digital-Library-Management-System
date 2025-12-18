package com.dlms.userservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldRegisterUser() {
        Map<String, Object> user = new HashMap<>();
        user.put("name", "Ana");
        user.put("email", "ana@example.com");

        ResponseEntity<String> response =
                restTemplate.postForEntity("/users", user, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
