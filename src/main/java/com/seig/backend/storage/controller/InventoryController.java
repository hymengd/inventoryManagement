package com.seig.backend.storage.controller;

import com.seig.backend.common.Result;
import com.seig.backend.pojo.dto.SkuInventoryRequestDto;
import com.seig.backend.pojo.vo.InventoryLocationVo;
import com.seig.backend.storage.entity.InventoryBatch;
import com.seig.backend.storage.entity.InventoryDetail;
import com.seig.backend.storage.service.InventoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//  库存批次与明细 ---> 一个批次在多个货位的明细

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    // InventoryBatch 相关操作
    @PostMapping("/batch/add")
    public Result<InventoryBatch> createInventoryBatch(@RequestBody InventoryBatch inventoryBatch) {
        try {
            InventoryBatch createdBatch = inventoryService.createInventoryBatch(inventoryBatch);
            if (createdBatch != null) {
                return Result.success("库存批次创建成功", createdBatch);
            } else {
                return Result.error(500, "库存批次创建失败", null);
            }
        } catch (Exception e) {
            return Result.error(500, "创建库存批次时发生错误：" + e.getMessage(), null);
        }
    }

    @GetMapping("/batch/{batchId}")
    public Result<InventoryBatch> getInventoryBatchById(@PathVariable Integer batchId) {
        try {
            InventoryBatch inventoryBatch = inventoryService.getInventoryBatchById(batchId);
            if (inventoryBatch != null) {
                return Result.success("查询成功", inventoryBatch);
            } else {
                return Result.error(404, "库存批次不存在", null);
            }
        } catch (Exception e) {
            return Result.error(500, "查询库存批次时发生错误：" + e.getMessage(), null);
        }
    }

    @GetMapping("/batch/getAll")
    public Result<List<InventoryBatch>> getAllInventoryBatches() {
        try {
            List<InventoryBatch> batches = inventoryService.getAllInventoryBatches();
            return Result.success("查询成功", batches);
        } catch (Exception e) {
            return Result.error(500, "查询库存批次列表时发生错误：" + e.getMessage(), null);
        }
    }

    @GetMapping("/batch/bySku/{skuId}")
    public Result<List<InventoryBatch>> getInventoryBatchesBySkuId(@PathVariable Integer skuId) {
        try {
            List<InventoryBatch> batches = inventoryService.getInventoryBatchesBySkuId(skuId);
            return Result.success("查询成功", batches);
        } catch (Exception e) {
            return Result.error(500, "查询库存批次列表时发生错误：" + e.getMessage(), null);
        }
    }

    @PutMapping("/batch/{batchId}")
    public Result<InventoryBatch> updateInventoryBatch(@PathVariable Integer batchId, @RequestBody InventoryBatch inventoryBatch) {
        try {
            inventoryBatch.setBatchId(batchId);
            InventoryBatch updatedBatch = inventoryService.updateInventoryBatch(inventoryBatch);
            if (updatedBatch != null) {
                return Result.success("库存批次更新成功", updatedBatch);
            } else {
                return Result.error(404, "库存批次不存在，无法更新", null);
            }
        } catch (Exception e) {
            return Result.error(500, "更新库存批次时发生错误：" + e.getMessage(), null);
        }
    }

    @DeleteMapping("/batch/{batchId}")
    public Result<Void> deleteInventoryBatch(@PathVariable Integer batchId) {
        try {
            boolean success = inventoryService.deleteInventoryBatch(batchId);
            if (success) {
                return Result.success("库存批次删除成功");
            } else {
                return Result.error(404, "库存批次不存在，无法删除");
            }
        } catch (Exception e) {
            return Result.error(500, "删除库存批次时发生错误：" + e.getMessage());
        }
    }

    // InventoryDetail 相关操作
    @PostMapping("/detail/add")
    public Result<InventoryDetail> createInventoryDetail(@RequestBody InventoryDetail inventoryDetail) {
        try {
            InventoryDetail createdDetail = inventoryService.createInventoryDetail(inventoryDetail);
            if (createdDetail != null) {
                return Result.success("库存明细创建成功", createdDetail);
            } else {
                return Result.error(500, "库存明细创建失败", null);
            }
        } catch (Exception e) {
            return Result.error(500, "创建库存明细时发生错误：" + e.getMessage(), null);
        }
    }

    @GetMapping("/detail/{detailId}")
    public Result<InventoryDetail> getInventoryDetailById(@PathVariable Integer detailId) {
        try {
            InventoryDetail inventoryDetail = inventoryService.getInventoryDetailById(detailId);
            if (inventoryDetail != null) {
                return Result.success("查询成功", inventoryDetail);
            } else {
                return Result.error(404, "库存明细不存在", null);
            }
        } catch (Exception e) {
            return Result.error(500, "查询库存明细时发生错误：" + e.getMessage(), null);
        }
    }

    @GetMapping("/detail/getAll")
    public Result<List<InventoryDetail>> getAllInventoryDetails() {
        try {
            List<InventoryDetail> details = inventoryService.getAllInventoryDetails();
            return Result.success("查询成功", details);
        } catch (Exception e) {
            return Result.error(500, "查询库存明细列表时发生错误：" + e.getMessage(), null);
        }
    }

    @GetMapping("/detail/byBatch/{batchId}")
    public Result<List<InventoryDetail>> getInventoryDetailsByBatchId(@PathVariable Integer batchId) {
        try {
            List<InventoryDetail> details = inventoryService.getInventoryDetailsByBatchId(batchId);
            return Result.success("查询成功", details);
        } catch (Exception e) {
            return Result.error(500, "查询库存明细列表时发生错误：" + e.getMessage(), null);
        }
    }

    @GetMapping("/detail/byLocation/{locationId}")
    public Result<List<InventoryDetail>> getInventoryDetailsByLocationId(@PathVariable Integer locationId) {
        try {
            List<InventoryDetail> details = inventoryService.getInventoryDetailsByLocationId(locationId);
            return Result.success("查询成功", details);
        } catch (Exception e) {
            return Result.error(500, "查询库存明细列表时发生错误：" + e.getMessage(), null);
        }
    }

    @PutMapping("/detail/{detailId}")
    public Result<InventoryDetail> updateInventoryDetail(@PathVariable Integer detailId, @RequestBody InventoryDetail inventoryDetail) {
        try {
            inventoryDetail.setDetailId(detailId);
            InventoryDetail updatedDetail = inventoryService.updateInventoryDetail(inventoryDetail);
            if (updatedDetail != null) {
                return Result.success("库存明细更新成功", updatedDetail);
            } else {
                return Result.error(404, "库存明细不存在，无法更新", null);
            }
        } catch (Exception e) {
            return Result.error(500, "更新库存明细时发生错误：" + e.getMessage(), null);
        }
    }

    @DeleteMapping("/detail/{detailId}")
    public Result<Void> deleteInventoryDetail(@PathVariable Integer detailId) {
        try {
            boolean success = inventoryService.deleteInventoryDetail(detailId);
            if (success) {
                return Result.success("库存明细删除成功");
            } else {
                return Result.error(404, "库存明细不存在，无法删除");
            }
        } catch (Exception e) {
            return Result.error(500, "删除库存明细时发生错误：" + e.getMessage());
        }
    }

    /**
     * 根据SKU和数量需求获取最优货位信息
     *
     * @param requestList SKU库存请求列表
     * @return 最优货位信息列表
     */
    @PostMapping("/optimal-locations")
    public Result<List<InventoryLocationVo>> getOptimalLocationsForSkus(
            @Valid @RequestBody List<SkuInventoryRequestDto> requestList) {
        try {
            if (requestList == null || requestList.isEmpty()) {
                return Result.error(400, "请求参数不能为空", null);
            }

            List<InventoryLocationVo> locations = inventoryService.getOptimalLocationsForSkus(requestList);
            return Result.success("查询成功", locations);
        } catch (Exception e) {
            return Result.error(500, "查询最优货位时发生错误：" + e.getMessage(), null);
        }
    }


    /**
     * 根据SKU和数量需求获取最优货位信息并锁定库存
     *
     * @param requestList SKU库存请求列表
     * @return 最优货位信息列表（已锁定的库存）
     */
    @PostMapping("/optimal-locations/lock")
    public Result<List<InventoryLocationVo>> lockOptimalLocationsForSkus(
            @Valid @RequestBody List<SkuInventoryRequestDto> requestList) {
        try {
            if (requestList == null || requestList.isEmpty()) {
                return Result.error(400, "请求参数不能为空", null);
            }

            List<InventoryLocationVo> locations = inventoryService.lockOptimalLocationsForSkus(requestList);
            return Result.success("库存锁定成功", locations);
        } catch (Exception e) {
            return Result.error(500, "锁定库存时发生错误：" + e.getMessage(), null);
        }
    }

    /**
     * 解锁库存
     *
     * @param lockedLocations 已锁定的货位信息列表
     * @return 操作结果
     */
    @DeleteMapping("/locked-locations")
    public Result<Void> unlockInventoryLocations(
            @Valid @RequestBody List<InventoryLocationVo> lockedLocations) {
        try {
            if (lockedLocations == null || lockedLocations.isEmpty()) {
                return Result.error(400, "请求参数不能为空", null);
            }

            boolean success = inventoryService.unlockInventoryLocations(lockedLocations);
            if (success) {
                return Result.success("库存解锁成功");
            } else {
                return Result.error(500, "库存解锁失败", null);
            }
        } catch (Exception e) {
            return Result.error(500, "解锁库存时发生错误：" + e.getMessage(), null);
        }
    }

//    /**
//     * 查询最优货位信息（不锁定库存，仅查询）
//     *
//     * @param requestList SKU库存请求列表
//     * @return 最优货位信息列表
//     */
//    @PostMapping("/optimal-locations/query")
//    public Result<List<InventoryLocationVo>> getOptimalLocationsForSkus(
//            @Valid @RequestBody List<SkuInventoryRequestDto> requestList) {
//        try {
//            if (requestList == null || requestList.isEmpty()) {
//                return Result.error(400, "请求参数不能为空", null);
//            }
//
//            List<InventoryLocationVo> locations = inventoryService.getOptimalLocationsForSkus(requestList);
//            return Result.success("查询成功", locations);
//        } catch (Exception e) {
//            return Result.error(500, "查询最优货位时发生错误：" + e.getMessage(), null);
//        }
//    }


}
