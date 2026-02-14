package com.seig.backend.service.impl;

import com.seig.backend.entity.storage.QuarantineBatch;
import com.seig.backend.mapper.QuarantineBatchMapper;
import com.seig.backend.service.QuarantineBatchService;
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


