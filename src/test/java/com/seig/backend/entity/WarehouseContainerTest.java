package com.seig.backend.entity;

import com.seig.backend.entity.storage.WarehouseContainer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WarehouseContainerTest {

    @Test
    void testGettersAndSetters() {
        WarehouseContainer container = new WarehouseContainer();
        container.setContainerId(1);
        container.setZoneId(2);
        container.setContainerCode("CONT001");
        container.setContainerName("Test Container");
        container.setShelfLayers((byte) 5);
        container.setShelfColumns((byte) 10);
        container.setTotalLocations(50);

        assertEquals(1, container.getContainerId());
        assertEquals(2, container.getZoneId());
        assertEquals("CONT001", container.getContainerCode());
        assertEquals("Test Container", container.getContainerName());
        assertEquals(5, container.getShelfLayers().intValue());
        assertEquals(10, container.getShelfColumns().intValue());
        assertEquals(50, container.getTotalLocations());
    }
}
