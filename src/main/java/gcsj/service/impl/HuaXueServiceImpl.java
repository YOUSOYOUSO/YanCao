package gcsj.service.impl;

import gcsj.entity.HuaXue;
import gcsj.repository.HuaXueRepository;
import gcsj.service.HuaXueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HuaXueServiceImpl implements HuaXueService {

    @Autowired
    private HuaXueRepository huaXueRepository;


    @Override
    public HuaXue Insert(HuaXue huaXue) {
        huaXueRepository.save(huaXue);
        return huaXue;
    }

    @Override
    public void DeleteHuaXueById(long id) {
        huaXueRepository.deleteById(id);
    }

    @Override
    public void UpdateHuaXue(HuaXue huaXue) {
        huaXueRepository.save(huaXue);
    }

    @Override
    public List<HuaXue> getHuaXueList() {

        return huaXueRepository.findAll();
    }

}