package com.seig.backend.entity;

import com.seig.backend.storage.entity.QuarantineBatch;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

class QuarantineBatchTest {

    @Test
    void testGettersAndSetters() {
        QuarantineBatch batch = new QuarantineBatch();
        batch.setQuarantineId(1);
        batch.setBatchId(2);
        batch.setPurchaseOrderId(3);
        batch.setSkuId(4);
        batch.setSupplierId(5);
        batch.setExpectedQuantity(new BigDecimal("100"));
        batch.setActualQuantity(new BigDecimal("95"));
        batch.setReceivedDate(LocalDate.of(2023, 10, 1));
        batch.setReceiver("John Doe");
        batch.setQuarantineLocation("Zone A");
        batch.setQuarantineStatus((byte) 1);

        assertEquals(1, batch.getQuarantineId());
        assertEquals(2, batch.getBatchId());
        assertEquals(3, batch.getPurchaseOrderId());
        assertEquals(4, batch.getSkuId());
        assertEquals(5, batch.getSupplierId());
        assertEquals(new BigDecimal("100"), batch.getExpectedQuantity());
        assertEquals(new BigDecimal("95"), batch.getActualQuantity());
        assertEquals(LocalDate.of(2023, 10, 1), batch.getReceivedDate());
        assertEquals("John Doe", batch.getReceiver());
        assertEquals("Zone A", batch.getQuarantineLocation());
        assertEquals((byte) 1, batch.getQuarantineStatus());
    }
}
