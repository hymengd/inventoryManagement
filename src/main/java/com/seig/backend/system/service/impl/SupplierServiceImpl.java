package com.seig.backend.system.service.impl;

import com.seig.backend.system.entity.Supplier;
import com.seig.backend.system.mapper.SupplierMapper;
import com.seig.backend.system.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {
    
    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierMapper.selectAllSuppliers();    }

    @Override
    public int addSupplier(Supplier supplier) {
        // 设置默认值或验证
        supplier.setCreatedAt(LocalDateTime.now());
        supplier.setUpdatedAt(LocalDateTime.now());

        int result = supplierMapper.insert(supplier);
        if (result > 0) {
            return supplier.getSupplierId(); // MyBatis会自动填充自增ID
        }
        throw new RuntimeException("供应商添加失败");
    }

    @Override
    public boolean updateSupplierById(Supplier supplier) {
        supplier.setUpdatedAt(LocalDateTime.now()); // 更新时间戳

        int result = supplierMapper.updateByPrimaryKey(supplier);
        return result > 0; // 返回是否更新成功
    }

    @Override
    public boolean deleteSupplierById(Integer supplierId) {
        int result = supplierMapper.deleteByPrimaryKey(supplierId);
        return result > 0;
    }
    @Override
    public Supplier getSupplierById(Integer supplierId) {
        return supplierMapper.selectByPrimaryKey(supplierId);
    }

}
