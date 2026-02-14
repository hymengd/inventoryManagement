package com.seig.backend.controller;

import com.seig.backend.common.Result;
import com.seig.backend.entity.storage.WarehouseContainer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WarehouseContainerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetAllContainers() {
        ResponseEntity<Result<List<WarehouseContainer>>> response = restTemplate.exchange(
                "/containers",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Result<List<WarehouseContainer>>>() {}
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(200, response.getBody().getCode());
    }

    @Test
    void testGetContainerById() {
        Integer containerId = 1;
        // ✅ 修正：使用 exchange 代替 getForEntity
        ResponseEntity<Result<WarehouseContainer>> response = restTemplate.exchange(
                "/containers/" + containerId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Result<WarehouseContainer>>() {}
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(200, response.getBody().getCode());
        assertNotNull(response.getBody().getData());
    }

    @Test
    void testAddContainer() {
        WarehouseContainer container = new WarehouseContainer();
        container.setContainerName("Test Container");
        container.setZoneId(1);

        // ✅ 修正：使用 exchange 代替 postForEntity
        HttpEntity<WarehouseContainer> requestEntity = new HttpEntity<>(container);
        ResponseEntity<Result<WarehouseContainer>> response = restTemplate.exchange(
                "/containers",
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<Result<WarehouseContainer>>() {}
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(200, response.getBody().getCode());
        assertNotNull(response.getBody().getData());
    }

    @Test
    void testUpdateContainer() {
        Integer containerId = 1;
        WarehouseContainer container = new WarehouseContainer();
        container.setContainerName("Updated Container");

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<WarehouseContainer> requestEntity = new HttpEntity<>(container, headers);

        ResponseEntity<Result<WarehouseContainer>> response = restTemplate.exchange(
                "/containers/" + containerId,
                HttpMethod.PUT,
                requestEntity,
                new ParameterizedTypeReference<Result<WarehouseContainer>>() {}
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(200, response.getBody().getCode());
    }

    @Test
    void testDeleteContainer() {
        Integer containerId = 1;

        ResponseEntity<Result<Void>> response = restTemplate.exchange(
                "/containers/" + containerId,
                HttpMethod.DELETE,
                null,
                new ParameterizedTypeReference<Result<Void>>() {}
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(200, response.getBody().getCode());
    }
}