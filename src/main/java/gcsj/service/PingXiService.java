package gcsj.service;


import gcsj.entity.PingXi;

import java.util.List;

public interface PingXiService {
    PingXi Insert(PingXi pingXi);
    void DeletePingXiById(long id);
    void UpdatePingXiById(PingXi pingXi);
    List<PingXi> getPingXiList();
}
