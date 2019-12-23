package gcsj.service.impl;

import gcsj.entity.PingXi;
import gcsj.repository.PingXiRepository;
import gcsj.service.PingXiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PingXiServiceImpl implements PingXiService {

    @Autowired
    private PingXiRepository pingXiRepository;

    @Override
    public PingXi Insert(PingXi pingXi) {
        pingXiRepository.save(pingXi);
        return pingXi;
    }

    @Override
    public void DeletePingXiById(long id) {
        pingXiRepository.deleteById(id);
    }

    @Override
    public void UpdatePingXiById(PingXi pingXi) {
        pingXiRepository.save(pingXi);
    }

    @Override
    public List<PingXi> getPingXiList() {
       return pingXiRepository.findAll();
    }
}
