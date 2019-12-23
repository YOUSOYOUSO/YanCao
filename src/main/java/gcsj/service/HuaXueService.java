package gcsj.service;

import gcsj.entity.HuaXue;

import java.util.List;

public interface HuaXueService {
    HuaXue Insert(HuaXue huaXue);
    void DeleteHuaXueById(long id);
    void UpdateHuaXue(HuaXue huaXue);
    List<HuaXue> getHuaXueList();

}
