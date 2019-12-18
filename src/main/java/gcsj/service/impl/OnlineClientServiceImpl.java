package gcsj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gcsj.entity.OnlineClient;
import gcsj.repository.OnlineClientRepository;
import gcsj.service.OnlineClientService;

import java.util.List;


@Service
public class OnlineClientServiceImpl implements OnlineClientService {

    @Autowired
    private OnlineClientRepository onlineClientRepository;


    @Override
    public OnlineClient Insert(OnlineClient client) {

        onlineClientRepository.save(client);
        return client;
    }

    @Override
    public void DeleteClientById(long id) {
        onlineClientRepository.deleteById(id);
    }

    @Override
    public void UpdateClients(OnlineClient client) {
        onlineClientRepository.save(client);
    }

    @Override
    public List<OnlineClient> getClientList() {
        return onlineClientRepository.findAll();
    }

    @Override
    public List<OnlineClient> findByIp(String ip) {
        return null;
    }
}