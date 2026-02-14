package com.seig.backend.controller;

import com.seig.backend.common.Result;
import com.seig.backend.entity.storage.WarehouseZone;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WarehouseZoneControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetAllZones() {
        ResponseEntity<Result<List<WarehouseZone>>> response = restTemplate.exchange(
                "/zones",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Result<List<WarehouseZone>>>() {}
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(200, response.getBody().getCode());
    }

    @Test
    void testGetZoneById() {
        Integer zoneId = 1;
        // ✅ 修正：使用 exchange 代替 getForEntity
        ResponseEntity<Result<WarehouseZone>> response = restTemplate.exchange(
                "/zones/" + zoneId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Result<WarehouseZone>>() {}
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(200, response.getBody().getCode());
        assertNotNull(response.getBody().getData());
    }

    @Test
    void testAddZone() {
        WarehouseZone zone = new WarehouseZone();
        zone.setZoneName("Test Zone");
        zone.setWarehouseId(1);

        // ✅ 修正：使用 exchange 代替 postForEntity
        HttpEntity<WarehouseZone> requestEntity = new HttpEntity<>(zone);
        ResponseEntity<Result<WarehouseZone>> response = restTemplate.exchange(
                "/zones",
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<Result<WarehouseZone>>() {}
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(200, response.getBody().getCode());
        assertNotNull(response.getBody().getData());
    }

    @Test
    void testUpdateZone() {
        Integer zoneId = 1;
        WarehouseZone zone = new WarehouseZone();
        zone.setZoneName("Updated Zone");

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<WarehouseZone> requestEntity = new HttpEntity<>(zone, headers);

        ResponseEntity<Result<WarehouseZone>> response = restTemplate.exchange(
                "/zones/" + zoneId,
                HttpMethod.PUT,
                requestEntity,
                new ParameterizedTypeReference<Result<WarehouseZone>>() {}
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(200, response.getBody().getCode());
    }

    @Test
    void testDeleteZone() {
        Integer zoneId = 1;

        ResponseEntity<Result<Void>> response = restTemplate.exchange(
                "/zones/" + zoneId,
                HttpMethod.DELETE,
                null,
                new ParameterizedTypeReference<Result<Void>>() {}
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(200, response.getBody().getCode());
    }
}