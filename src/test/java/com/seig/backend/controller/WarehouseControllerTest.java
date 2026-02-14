package com.seig.backend.controller;

import com.seig.backend.common.Result;
import com.seig.backend.entity.storage.Warehouse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WarehouseControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetAllWarehouses() {
        ResponseEntity<Result<List<Warehouse>>> response = restTemplate.exchange(
                "/warehouses",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Result<List<Warehouse>>>() {}
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(200, response.getBody().getCode());
    }

    @Test
    void testGetWarehouseById() {
        Integer warehouseId = 1;
        // ✅ 修正：使用 exchange 代替 getForEntity
        ResponseEntity<Result<Warehouse>> response = restTemplate.exchange(
                "/warehouses/" + warehouseId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Result<Warehouse>>() {}
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(200, response.getBody().getCode());
        assertNotNull(response.getBody().getData());
    }

    @Test
    void testAddWarehouse() {
        Warehouse warehouse = new Warehouse();
        warehouse.setWarehouseName("Test Warehouse");
        warehouse.setAddress("Test Address");

        // ✅ 修正：使用 exchange 代替 postForEntity
        HttpEntity<Warehouse> requestEntity = new HttpEntity<>(warehouse);
        ResponseEntity<Result<Warehouse>> response = restTemplate.exchange(
                "/warehouses",
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<Result<Warehouse>>() {}
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(200, response.getBody().getCode());
        assertNotNull(response.getBody().getData());
    }

    @Test
    void testUpdateWarehouse() {
        Integer warehouseId = 1;
        Warehouse warehouse = new Warehouse();
        warehouse.setWarehouseName("Updated Warehouse");
        warehouse.setAddress("Updated Address");

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Warehouse> requestEntity = new HttpEntity<>(warehouse, headers);

        ResponseEntity<Result<Warehouse>> response = restTemplate.exchange(
                "/warehouses/" + warehouseId,
                HttpMethod.PUT,
                requestEntity,
                new ParameterizedTypeReference<Result<Warehouse>>() {}
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(200, response.getBody().getCode());
    }

    @Test
    void testDeleteWarehouse() {
        Integer warehouseId = 1;

        ResponseEntity<Result<Void>> response = restTemplate.exchange(
                "/warehouses/" + warehouseId,
                HttpMethod.DELETE,
                null,
                new ParameterizedTypeReference<Result<Void>>() {}
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(200, response.getBody().getCode());
    }
}