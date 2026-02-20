package com.seig.backend.storage.service.impl;

import com.seig.backend.storage.entity.QuarantineBatch;
import com.seig.backend.storage.mapper.QuarantineBatchMapper;
import com.seig.backend.storage.service.QuarantineBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class QuarantineBatchServiceImpl implements QuarantineBatchService {

    @Autowired
    private QuarantineBatchMapper quarantineBatchMapper;

    @Override
    public QuarantineBatch createQuarantineBatch(QuarantineBatch quarantineBatch) {
        quarantineBatch.setCreatedAt(LocalDateTime.now());
        quarantineBatch.setUpdatedAt(LocalDateTime.now());
        int result = quarantineBatchMapper.insert(quarantineBatch);
        if (result > 0) {
            return quarantineBatch;
        }
        return null;
    }
}


