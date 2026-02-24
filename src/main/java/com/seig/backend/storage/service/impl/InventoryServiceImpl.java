package com.seig.backend.storage.service.impl;

import com.seig.backend.pojo.dto.SkuInventoryRequestDto;
import com.seig.backend.pojo.vo.InventoryLocationVo;
import com.seig.backend.storage.entity.*;
import com.seig.backend.storage.mapper.*;
import com.seig.backend.storage.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryBatchMapper inventoryBatchMapper;

    @Autowired
    private InventoryDetailMapper inventoryDetailMapper;

    @Autowired
    private StorageLocationMapper storageLocationMapper;

    @Autowired
    private WarehouseContainerMapper warehouseContainerMapper;

    @Autowired
    private WarehouseZoneMapper warehouseZoneMapper;

    @Autowired
    private WarehouseMapper warehouseMapper;

    // InventoryBatch 相关操作
    @Override
    public InventoryBatch createInventoryBatch(InventoryBatch inventoryBatch) {
        int result = inventoryBatchMapper.insert(inventoryBatch);
        if (result > 0) {
            return inventoryBatch;
        }
        return null;
    }

    @Override
    public InventoryBatch getInventoryBatchById(Integer batchId) {
        return inventoryBatchMapper.selectById(batchId);
    }

    @Override
    public List<InventoryBatch> getAllInventoryBatches() {
        return inventoryBatchMapper.selectAll();
    }

    @Override
    public List<InventoryBatch> getInventoryBatchesBySkuId(Integer skuId) {
        return inventoryBatchMapper.selectBySkuId(skuId);
    }

    @Override
    public InventoryBatch updateInventoryBatch(InventoryBatch inventoryBatch) {
        int result = inventoryBatchMapper.update(inventoryBatch);
        if (result > 0) {
            return inventoryBatch;
        }
        return null;
    }

    @Override
    public boolean deleteInventoryBatch(Integer batchId) {
        int result = inventoryBatchMapper.deleteById(batchId);
        return result > 0;
    }

    // InventoryDetail 相关操作
    @Override
    public InventoryDetail createInventoryDetail(InventoryDetail inventoryDetail) {
        int result = inventoryDetailMapper.insert(inventoryDetail);
        if (result > 0) {
            return inventoryDetail;
        }
        return null;
    }

    @Override
    public InventoryDetail getInventoryDetailById(Integer detailId) {
        return inventoryDetailMapper.selectById(detailId);
    }

    @Override
    public List<InventoryDetail> getAllInventoryDetails() {
        return inventoryDetailMapper.selectAll();
    }

    @Override
    public List<InventoryDetail> getInventoryDetailsByBatchId(Integer batchId) {
        return inventoryDetailMapper.selectByBatchId(batchId);
    }

    @Override
    public List<InventoryDetail> getInventoryDetailsByLocationId(Integer locationId) {
        return inventoryDetailMapper.selectByLocationId(locationId);
    }

    @Override
    public InventoryDetail updateInventoryDetail(InventoryDetail inventoryDetail) {
        int result = inventoryDetailMapper.update(inventoryDetail);
        if (result > 0) {
            return inventoryDetail;
        }
        return null;
    }

    @Override
    public boolean deleteInventoryDetail(Integer detailId) {
        int result = inventoryDetailMapper.deleteById(detailId);
        return result > 0;
    }

//    @Override
//    public List<InventoryLocationVo> getOptimalLocationsForSkus(List<SkuInventoryRequestDto> requestList) {
//        List<InventoryLocationVo> result = new ArrayList<>();
//
////      按SKU分组处理 [{ skuId:1001,quantity:10 },{},{}]
////      1.skuId的库存 2.筛选有效期，先进先出排序 3.锁定合适的数量
//        for (SkuInventoryRequestDto request : requestList) {
//            Integer skuId = request.getSkuId();
//            BigDecimal requiredQuantity = request.getQuantity();
//
//            // 获取该SKU的所有库存明细
//            List<InventoryDetailWithLocation> inventoryDetails = inventoryDetailMapper.selectByMultipleSkuIdsWithJoin(
//                    Collections.singletonList(skuId));
//
//            // 过滤掉3个月内即将过期的库存，并按有效期排序（先到期的优先）
//            LocalDateTime threeMonthsLater = LocalDateTime.now().plusMonths(3);
//            List<InventoryDetailWithLocation> validDetails = inventoryDetails.stream()
//                    .filter(detail -> {
//                        // 需要检查货位的有效期
//                        StorageLocation location = storageLocationMapper.selectById(detail.getLocationId());
//                        if (location != null && location.getExpiryDate() != null) {
//                            return location.getExpiryDate().isAfter(threeMonthsLater);
//                        }
//                        return true; // 如果没有设置有效期，默认认为有效
//                    })
//                    .sorted((d1, d2) -> {
//                        StorageLocation loc1 = storageLocationMapper.selectById(d1.getLocationId());
//                        StorageLocation loc2 = storageLocationMapper.selectById(d2.getLocationId());
//
//                        if (loc1 != null && loc2 != null &&
//                                loc1.getExpiryDate() != null && loc2.getExpiryDate() != null) {
//                            return loc1.getExpiryDate().compareTo(loc2.getExpiryDate());
//                        }
//                        return 0;
//                    })
//                    .collect(Collectors.toList());
//
//            // 按需求数量分配货位
//            BigDecimal remainingQuantity = requiredQuantity;
//            for (InventoryDetailWithLocation detail : validDetails) {
//                if (remainingQuantity.compareTo(BigDecimal.ZERO) <= 0) {
//                    break;
//                }
//
//                BigDecimal availableQty = detail.getAvailableQuantity() != null ?
//                        detail.getAvailableQuantity() : detail.getQuantity();
//
//                if (availableQty.compareTo(BigDecimal.ZERO) > 0) {
//                    BigDecimal allocateQty = availableQty.min(remainingQuantity);
//
//                    // 构建完整货位编码
//                    InventoryLocationVo locationVo = buildFullLocationCode(detail);
//                    locationVo.setSkuId(skuId);
//                    locationVo.setAllocatedQuantity(allocateQty);
//                    locationVo.setBatchId(detail.getBatchId());
//
//                    result.add(locationVo);
//
//                    remainingQuantity = remainingQuantity.subtract(allocateQty);
//                }
//            }
//
//            // 如果还有剩余需求未满足，可以在这里处理（比如返回错误信息）
//            if (remainingQuantity.compareTo(BigDecimal.ZERO) > 0) {
//                // 可以添加警告或错误处理逻辑
//            }
//        }
//
//        return result;
//    }

    /**
     * 构建完整的货位编码信息
     */
    private InventoryLocationVo buildFullLocationCode(InventoryDetailWithLocation detail) {
        InventoryLocationVo vo = new InventoryLocationVo();

        // 获取货位信息
        StorageLocation location = storageLocationMapper.selectById(detail.getLocationId());
        if (location == null) {
            return vo;
        }

        vo.setLocationId(detail.getLocationId());
        vo.setLocationCode(location.getLocationCode());
        if (location.getExpiryDate() != null) {
            vo.setExpiryDate(location.getExpiryDate().toString());
        }

        // 获取容器信息
        WarehouseContainer container = warehouseContainerMapper.selectById(location.getContainerId());
        if (container != null) {
            vo.setContainerCode(container.getContainerCode());

            // 获取库区信息
            WarehouseZone zone = warehouseZoneMapper.selectById(container.getZoneId());
            if (zone != null) {
                vo.setZoneCode(zone.getZoneCode());

                // 获取仓库信息
                Warehouse warehouse = warehouseMapper.selectById(zone.getWarehouseId());
                if (warehouse != null) {
                    vo.setWarehouseCode(warehouse.getWarehouseCode());
                }
            }
        }

        // 构建完整编码
        StringBuilder fullCode = new StringBuilder();
        if (vo.getWarehouseCode() != null) {
            fullCode.append(vo.getWarehouseCode());
        }
        if (vo.getZoneCode() != null) {
            fullCode.append("-").append(vo.getZoneCode());
        }
        if (vo.getContainerCode() != null) {
            fullCode.append("-").append(vo.getContainerCode());
        }
        if (vo.getLocationCode() != null) {
            fullCode.append("-").append(vo.getLocationCode());
        }
        vo.setFullLocationCode(fullCode.toString());

        return vo;
    }



       @Override
       public List<InventoryLocationVo> getOptimalLocationsForSkus(List<SkuInventoryRequestDto> requestList) {
           List<InventoryLocationVo> result = new ArrayList<>();

   //      按SKU分组处理 [{ skuId:1001,quantity:10 },{},{}]
   //      1.skuId的库存 2.筛选有效期，先进先出排序 3.锁定合适的数量
           for (SkuInventoryRequestDto request : requestList) {
               Integer skuId = request.getSkuId();
               BigDecimal requiredQuantity = request.getQuantity();

               // 获取该SKU的所有库存明细（不包含已锁定的）
               List<InventoryDetailWithLocation> inventoryDetails = inventoryDetailMapper.selectAvailableInventoryBySkuIds(
                       Collections.singletonList(skuId));

               // 过滤掉3个月内即将过期的库存，并按有效期排序（先到期的优先）
               LocalDateTime threeMonthsLater = LocalDateTime.now().plusMonths(3);
               List<InventoryDetailWithLocation> validDetails = inventoryDetails.stream()
                       .filter(detail -> {
                           // 需要检查货位的有效期
                           StorageLocation location = storageLocationMapper.selectById(detail.getLocationId());
                           if (location != null && location.getExpiryDate() != null) {
                               return location.getExpiryDate().isAfter(threeMonthsLater);
                           }
                           return true; // 如果没有设置有效期，默认认为有效
                       })
                       .sorted((d1, d2) -> {
                           StorageLocation loc1 = storageLocationMapper.selectById(d1.getLocationId());
                           StorageLocation loc2 = storageLocationMapper.selectById(d2.getLocationId());

                           if (loc1 != null && loc2 != null &&
                                   loc1.getExpiryDate() != null && loc2.getExpiryDate() != null) {
                               return loc1.getExpiryDate().compareTo(loc2.getExpiryDate());
                           }
                           return 0;
                       })
                       .collect(Collectors.toList());

               // 按需求数量分配货位（仅查询，不锁定）
               BigDecimal remainingQuantity = requiredQuantity;
               for (InventoryDetailWithLocation detail : validDetails) {
                   if (remainingQuantity.compareTo(BigDecimal.ZERO) <= 0) {
                       break;
                   }

                   BigDecimal availableQty = detail.getAvailableQuantity() != null ?
                           detail.getAvailableQuantity() : detail.getQuantity();

                   // 减去已锁定的数量得到实际可用数量
                   BigDecimal actualAvailable = availableQty.subtract(
                       detail.getLockedQuantity() != null ? detail.getLockedQuantity() : BigDecimal.ZERO
                   );

                   if (actualAvailable.compareTo(BigDecimal.ZERO) > 0) {
                       BigDecimal allocateQty = actualAvailable.min(remainingQuantity);

                       // 构建完整货位编码
                       InventoryLocationVo locationVo = buildFullLocationCode(detail);
                       locationVo.setSkuId(skuId);
                       locationVo.setAllocatedQuantity(allocateQty);
                       locationVo.setBatchId(detail.getBatchId());

                       result.add(locationVo);

                       remainingQuantity = remainingQuantity.subtract(allocateQty);
                   }
               }

               // 如果还有剩余需求未满足，可以在这里处理（比如返回错误信息）
               if (remainingQuantity.compareTo(BigDecimal.ZERO) > 0) {
                   // 可以添加警告或错误处理逻辑
               }
           }

           return result;
       }

       @Override
       @Transactional
       public List<InventoryLocationVo> lockOptimalLocationsForSkus(List<SkuInventoryRequestDto> requestList) {
           List<InventoryLocationVo> result = new ArrayList<>();

           try {
               // 先验证库存是否足够
               if (!validateInventoryAvailability(requestList)) {
                   throw new RuntimeException("库存不足，无法锁定");
               }

               // 按SKU分组处理
               for (SkuInventoryRequestDto request : requestList) {
                   Integer skuId = request.getSkuId();
                   BigDecimal requiredQuantity = request.getQuantity();

                   // 获取该SKU的所有可用库存明细（排除已锁定的）
                   List<InventoryDetailWithLocation> inventoryDetails = inventoryDetailMapper.selectAvailableInventoryBySkuIds(
                           Collections.singletonList(skuId));

                   // 过滤和排序逻辑同上
                   LocalDateTime threeMonthsLater = LocalDateTime.now().plusMonths(3);
                   List<InventoryDetailWithLocation> validDetails = inventoryDetails.stream()
                           .filter(detail -> {
                               StorageLocation location = storageLocationMapper.selectById(detail.getLocationId());
                               if (location != null && location.getExpiryDate() != null) {
                                   return location.getExpiryDate().isAfter(threeMonthsLater);
                               }
                               return true;
                           })
                           .sorted((d1, d2) -> {
                               StorageLocation loc1 = storageLocationMapper.selectById(d1.getLocationId());
                               StorageLocation loc2 = storageLocationMapper.selectById(d2.getLocationId());

                               if (loc1 != null && loc2 != null &&
                                       loc1.getExpiryDate() != null && loc2.getExpiryDate() != null) {
                                   return loc1.getExpiryDate().compareTo(loc2.getExpiryDate());
                               }
                               return 0;
                           })
                           .collect(Collectors.toList());

                   // 实际锁定库存
                   BigDecimal remainingQuantity = requiredQuantity;
                   for (InventoryDetailWithLocation detail : validDetails) {
                       if (remainingQuantity.compareTo(BigDecimal.ZERO) <= 0) {
                           break;
                       }

                       BigDecimal availableQty = detail.getAvailableQuantity() != null ?
                               detail.getAvailableQuantity() : detail.getQuantity();
                       BigDecimal lockedQty = detail.getLockedQuantity() != null ?
                               detail.getLockedQuantity() : BigDecimal.ZERO;
                       BigDecimal actualAvailable = availableQty.subtract(lockedQty);

                       if (actualAvailable.compareTo(BigDecimal.ZERO) > 0) {
                           BigDecimal toLockQty = actualAvailable.min(remainingQuantity);

                           // 执行锁定操作（数据库层面的原子操作）
                           int updatedRows = inventoryDetailMapper.lockInventoryQuantity(
                                   detail.getDetailId(), toLockQty);

                           if (updatedRows > 0) {
                               // 锁定成功，更新批次的锁定数量
                               updateBatchLockedQuantity(detail.getBatchId(), toLockQty);

                               // 构建返回结果
                               InventoryLocationVo locationVo = buildFullLocationCode(detail);
                               locationVo.setSkuId(skuId);
                               locationVo.setAllocatedQuantity(toLockQty);
                               locationVo.setBatchId(detail.getBatchId());

                               result.add(locationVo);
                               remainingQuantity = remainingQuantity.subtract(toLockQty);
                           } else {
                               // 锁定失败，可能是并发问题
                               throw new RuntimeException("库存锁定失败，可能已被其他请求占用");
                           }
                       }
                   }

                   // 如果还有剩余需求未满足
                   if (remainingQuantity.compareTo(BigDecimal.ZERO) > 0) {
                       // 回滚已锁定的库存
                       rollbackLockedInventory(result);
                       throw new RuntimeException("SKU " + skuId + " 库存不足，缺少数量: " + remainingQuantity);
                   }
               }

               return result;

           } catch (Exception e) {
               // 发生异常时回滚所有已锁定的库存
               rollbackLockedInventory(result);
               throw new RuntimeException("库存锁定过程中发生错误: " + e.getMessage(), e);
           }
       }

       @Override
       @Transactional
       public boolean unlockInventoryLocations(List<InventoryLocationVo> lockedLocations) {
           try {
               for (InventoryLocationVo location : lockedLocations) {
                   // 解锁库存明细
                   int updatedRows = inventoryDetailMapper.unlockInventoryQuantity(
                           location.getLocationId(), location.getAllocatedQuantity());

                   if (updatedRows > 0) {
                       // 同时更新批次的锁定数量
                       updateBatchUnlockedQuantity(location.getBatchId(), location.getAllocatedQuantity());
                   } else {
                       throw new RuntimeException("解锁失败，可能库存状态已改变");
                   }
               }
               return true;
           } catch (Exception e) {
               throw new RuntimeException("库存解锁过程中发生错误: " + e.getMessage(), e);
           }
       }

       @Override
       public boolean validateInventoryAvailability(List<SkuInventoryRequestDto> requestList) {
           for (SkuInventoryRequestDto request : requestList) {
               Integer skuId = request.getSkuId();
               BigDecimal requiredQuantity = request.getQuantity();

               // 获取该SKU的总可用库存（排除已锁定的）
               List<InventoryDetailWithLocation> inventoryDetails = inventoryDetailMapper.selectAvailableInventoryBySkuIds(
                       Collections.singletonList(skuId));

               BigDecimal totalAvailable = inventoryDetails.stream()
                       .map(detail -> {
                           BigDecimal available = detail.getAvailableQuantity() != null ?
                                   detail.getAvailableQuantity() : detail.getQuantity();
                           BigDecimal locked = detail.getLockedQuantity() != null ?
                                   detail.getLockedQuantity() : BigDecimal.ZERO;
                           return available.subtract(locked);
                       })
                       .reduce(BigDecimal.ZERO, BigDecimal::add);

               if (totalAvailable.compareTo(requiredQuantity) < 0) {
                   return false;
               }
           }
           return true;
       }

       /**
        * 更新批次的锁定数量
        */
       private void updateBatchLockedQuantity(Integer batchId, BigDecimal quantity) {
           InventoryBatch batch = inventoryBatchMapper.selectById(batchId);
           if (batch != null) {
               BigDecimal currentLocked = batch.getLockedQuantity() != null ?
                       batch.getLockedQuantity() : BigDecimal.ZERO;
               batch.setLockedQuantity(currentLocked.add(quantity));
               inventoryBatchMapper.update(batch);
           }
       }

       /**
        * 更新批次的解锁数量
        */
       private void updateBatchUnlockedQuantity(Integer batchId, BigDecimal quantity) {
           InventoryBatch batch = inventoryBatchMapper.selectById(batchId);
           if (batch != null) {
               BigDecimal currentLocked = batch.getLockedQuantity() != null ?
                       batch.getLockedQuantity() : BigDecimal.ZERO;
               batch.setLockedQuantity(currentLocked.subtract(quantity));
               inventoryBatchMapper.update(batch);
           }
       }

       /**
        * 回滚已锁定的库存
        */
       private void rollbackLockedInventory(List<InventoryLocationVo> lockedLocations) {
           try {
               for (InventoryLocationVo location : lockedLocations) {
                   inventoryDetailMapper.unlockInventoryQuantity(
                           location.getLocationId(), location.getAllocatedQuantity());
                   updateBatchUnlockedQuantity(location.getBatchId(), location.getAllocatedQuantity());
               }
           } catch (Exception e) {
               // 回滚失败时记录日志，但不抛出异常
               System.err.println("回滚锁定库存时发生错误: " + e.getMessage());
           }
       }

}
