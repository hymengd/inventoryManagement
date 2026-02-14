package com.seig.backend.controller;

import com.seig.backend.common.Result;
import com.seig.backend.entity.record.PurchaseArrival;
import com.seig.backend.service.PurchaseArrivalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchaseArrivals")
public class PurchaseArrivalController {

    @Autowired
    private PurchaseArrivalService purchaseArrivalService;

    /**
     * 创建到货记录
     */
    @PostMapping("/add")
    public Result<PurchaseArrival> createPurchaseArrival(@RequestBody PurchaseArrival purchaseArrival) {
        try {
            PurchaseArrival createdArrival = purchaseArrivalService.createPurchaseArrival(purchaseArrival);
            if (createdArrival != null) {
                return Result.success("到货记录创建成功", createdArrival);
            } else {
                return Result.error(500, "到货记录创建失败", null);
            }
        } catch (Exception e) {
            return Result.error(500, "创建到货记录时发生错误：" + e.getMessage(), null);
        }
    }

    /**
     * 根据到货单号查询到货记录
     */
    @GetMapping("/{arrivalId}")
    public Result<PurchaseArrival> getPurchaseArrivalById(@PathVariable Integer arrivalId) {
        try {
            PurchaseArrival purchaseArrival = purchaseArrivalService.getPurchaseArrivalById(arrivalId);
            if (purchaseArrival != null) {
                return Result.success("查询成功", purchaseArrival);
            } else {
                return Result.error(404, "到货记录不存在", null);
            }
        } catch (Exception e) {
            return Result.error(500, "查询到货记录时发生错误：" + e.getMessage(), null);
        }
    }

    /**
     * 查询所有到货记录
     */
    @GetMapping("/getAll")
    public Result<List<PurchaseArrival>> getAllPurchaseArrivals() {
        try {
            List<PurchaseArrival> arrivals = purchaseArrivalService.getAllPurchaseArrivals();
            return Result.success("查询成功", arrivals);
        } catch (Exception e) {
            return Result.error(500, "查询到货记录列表时发生错误：" + e.getMessage(), null);
        }
    }

    /**
     * 根据采购订单ID查询到货记录
     */
    @GetMapping("/byPoId/{poId}")
    public Result<List<PurchaseArrival>> getPurchaseArrivalsByPoId(@PathVariable Integer poId) {
        try {
            List<PurchaseArrival> arrivals = purchaseArrivalService.getPurchaseArrivalsByPoId(poId);
            return Result.success("查询成功", arrivals);
        } catch (Exception e) {
            return Result.error(500, "查询到货记录列表时发生错误：" + e.getMessage(), null);
        }
    }

    /**
     * 根据SKU ID查询到货记录
     */
    @GetMapping("/bySkuId/{skuId}")
    public Result<List<PurchaseArrival>> getPurchaseArrivalsBySkuId(@PathVariable Integer skuId) {
        try {
            List<PurchaseArrival> arrivals = purchaseArrivalService.getPurchaseArrivalsBySkuId(skuId);
            return Result.success("查询成功", arrivals);
        } catch (Exception e) {
            return Result.error(500, "查询到货记录列表时发生错误：" + e.getMessage(), null);
        }
    }

    /**
     * 更新到货记录
     */
    @PutMapping("/{arrivalId}")
    public Result<PurchaseArrival> updatePurchaseArrival(@PathVariable Integer arrivalId, @RequestBody PurchaseArrival purchaseArrival) {
        try {
            purchaseArrival.setArrivalId(arrivalId);
            PurchaseArrival updatedArrival = purchaseArrivalService.updatePurchaseArrival(purchaseArrival);
            if (updatedArrival != null) {
                return Result.success("到货记录更新成功", updatedArrival);
            } else {
                return Result.error(404, "到货记录不存在，无法更新", null);
            }
        } catch (Exception e) {
            return Result.error(500, "更新到货记录时发生错误：" + e.getMessage(), null);
        }
    }

    /**
     * 删除到货记录
     */
    @DeleteMapping("/{arrivalId}")
    public Result<Void> deletePurchaseArrival(@PathVariable Integer arrivalId) {
        try {
            boolean success = purchaseArrivalService.deletePurchaseArrivalById(arrivalId);
            if (success) {
                return Result.success("到货记录删除成功");
            } else {
                return Result.error(404, "到货记录不存在，无法删除");
            }
        } catch (Exception e) {
            return Result.error(500, "删除到货记录时发生错误：" + e.getMessage());
        }
    }
}
