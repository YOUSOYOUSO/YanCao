package gcsj.service;

import gcsj.entity.OnlineClient;

import java.util.List;

public interface OnlineClientService {
    OnlineClient Insert(OnlineClient client);
    void DeleteClientById(long id);
    void UpdateClients(OnlineClient client);
    List<OnlineClient> getClientList();
    List<OnlineClient> findByIp(String ip);

}
