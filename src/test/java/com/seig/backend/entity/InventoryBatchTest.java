package com.seig.backend.entity;

import com.seig.backend.entity.storage.InventoryBatch;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

class InventoryBatchTest {

    @Test
    void testGettersAndSetters() {
        InventoryBatch batch = new InventoryBatch();
        batch.setBatchId(1);
        batch.setBatchNumber("BATCH001");
        batch.setSkuId(2);
        batch.setSupplierId(3);
        batch.setPurchaseOrderId(4);
        batch.setProductionDate(LocalDate.of(2023, 1, 1));
        batch.setExpiryDate(LocalDate.of(2024, 1, 1));
        batch.setQuarantineDate(LocalDate.of(2023, 10, 1));
        batch.setQuarantinePerson("Jane Doe");
        batch.setQuarantineResult(1);
        batch.setPurchasePrice(new BigDecimal("10.00"));
        batch.setCostPrice(new BigDecimal("8.00"));
        batch.setTotalQuantity(new BigDecimal("1000"));
        batch.setAvailableQuantity(new BigDecimal("950"));
        batch.setLockedQuantity(new BigDecimal("50"));

        assertEquals(1, batch.getBatchId());
        assertEquals("BATCH001", batch.getBatchNumber());
        assertEquals(2, batch.getSkuId());
        assertEquals(3, batch.getSupplierId());
        assertEquals(4, batch.getPurchaseOrderId());
        assertEquals(LocalDate.of(2023, 1, 1), batch.getProductionDate());
        assertEquals(LocalDate.of(2024, 1, 1), batch.getExpiryDate());
        assertEquals(LocalDate.of(2023, 10, 1), batch.getQuarantineDate());
        assertEquals("Jane Doe", batch.getQuarantinePerson());
        assertEquals(1, batch.getQuarantineResult());
        assertEquals(new BigDecimal("10.00"), batch.getPurchasePrice());
        assertEquals(new BigDecimal("8.00"), batch.getCostPrice());
        assertEquals(new BigDecimal("1000"), batch.getTotalQuantity());
        assertEquals(new BigDecimal("950"), batch.getAvailableQuantity());
        assertEquals(new BigDecimal("50"), batch.getLockedQuantity());
    }
}
