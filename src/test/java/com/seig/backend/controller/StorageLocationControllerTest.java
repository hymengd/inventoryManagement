package com.seig.backend.controller;

import com.seig.backend.common.Result;
import com.seig.backend.entity.storage.StorageLocation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StorageLocationControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetAllLocations() {
        ResponseEntity<Result<List<StorageLocation>>> response = restTemplate.exchange(
                "/locations",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Result<List<StorageLocation>>>() {}
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(200, response.getBody().getCode());
    }

    @Test
    void testGetLocationById() {
        Integer locationId = 1;
        // 使用 exchange 代替 getForEntity
        ResponseEntity<Result<StorageLocation>> response = restTemplate.exchange(
                "/locations/{id}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Result<StorageLocation>>() {},
                locationId
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(200, response.getBody().getCode());
        assertNotNull(response.getBody().getData());
    }

    @Test
    void testAddLocation() {
        StorageLocation location = new StorageLocation();
        location.setLocationCode("LOC001");
        location.setContainerId(1);

        HttpEntity<StorageLocation> requestEntity = new HttpEntity<>(location);

        // 使用 exchange 代替 postForEntity
        ResponseEntity<Result<StorageLocation>> response = restTemplate.exchange(
                "/locations",
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<Result<StorageLocation>>() {}
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(200, response.getBody().getCode());
        assertNotNull(response.getBody().getData());
    }

    @Test
    void testUpdateLocation() {
        Integer locationId = 1;
        StorageLocation location = new StorageLocation();
        location.setLocationCode("Updated LOC001");

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<StorageLocation> requestEntity = new HttpEntity<>(location, headers);

        ResponseEntity<Result<StorageLocation>> response = restTemplate.exchange(
                "/locations/" + locationId,
                HttpMethod.PUT,
                requestEntity,
                new ParameterizedTypeReference<Result<StorageLocation>>() {}
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(200, response.getBody().getCode());
    }

    @Test
    void testDeleteLocation() {
        Integer locationId = 1;

        ResponseEntity<Result<Void>> response = restTemplate.exchange(
                "/locations/" + locationId,
                HttpMethod.DELETE,
                null,
                new ParameterizedTypeReference<Result<Void>>() {}
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(200, response.getBody().getCode());
    }
}