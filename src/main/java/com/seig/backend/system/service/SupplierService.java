package com.seig.backend.system.service;

import com.seig.backend.system.entity.Supplier;

import java.util.List;

public interface SupplierService {
    List<Supplier> getAllSuppliers();
    /**
     * 添加供应商
     */
    int addSupplier(Supplier supplier);
    
    /**
     * 根据supplierId修改供应商所有信息
     */
    boolean updateSupplierById(Supplier supplier);

    boolean deleteSupplierById(Integer supplierId);
    /**
     * 根据ID获取供应商信息
     */
    Supplier getSupplierById(Integer supplierId);


}
