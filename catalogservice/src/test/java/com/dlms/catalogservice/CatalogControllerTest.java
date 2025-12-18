package com.dlms.catalogservice;

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
class CatalogControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldAddBook() {
        Map<String, Object> book = new HashMap<>();
        book.put("title", "Clean Architecture");
        book.put("author", "Robert C. Martin");
        book.put("isbn", "9780134494166");

        ResponseEntity<String> response =
                restTemplate.postForEntity("/books", book, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
