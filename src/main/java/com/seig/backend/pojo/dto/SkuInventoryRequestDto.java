package com.seig.backend.pojo.dto;


//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Positive;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

/**
 * SKU库存查询请求DTO
 * 用于接收用户传来的skuId和quantity组合
 */
public class SkuInventoryRequestDto {

    /**
     * SKU ID
     */
    @NotNull(message = "SKU ID不能为空")
    private Integer skuId;

    /**
     * 需要的数量
     */
    @NotNull(message = "数量不能为空")
    @Positive(message = "数量必须大于0")
    private BigDecimal quantity;


    public @NotNull(message = "SKU ID不能为空") Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(@NotNull(message = "SKU ID不能为空") Integer skuId) {
        this.skuId = skuId;
    }

    public @NotNull(message = "数量不能为空") @Positive(message = "数量必须大于0") BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(@NotNull(message = "数量不能为空") @Positive(message = "数量必须大于0") BigDecimal quantity) {
        this.quantity = quantity;
    }
}
