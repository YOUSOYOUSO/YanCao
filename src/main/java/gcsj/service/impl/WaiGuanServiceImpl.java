package gcsj.service.impl;

import gcsj.entity.WaiGuan;
import gcsj.repository.WaiGuanRepository;
import gcsj.service.WaiGuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaiGuanServiceImpl implements WaiGuanService {

    @Autowired
    WaiGuanRepository waiGuanRepository;

    @Override
    public List<WaiGuan> getWaiguanList() {
        return waiGuanRepository.findAll();
    }
}
