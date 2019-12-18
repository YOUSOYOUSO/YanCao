package gcsj.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import gcsj.entity.OnlineClient;
import gcsj.service.OnlineClientService;

import java.util.List;

@RestController
public class OnlineClientController {

    @Autowired
    OnlineClientService onlineClientService;

    @RequestMapping("/allclients")
    public List<OnlineClient>getAllClients()
    {
        return onlineClientService.getClientList();
    }

    @RequestMapping("/insertclient")
    public OnlineClient insertNewClient(){
        OnlineClient onlineClient=new OnlineClient();
        onlineClient.setIp("12234.32.32.4234");
        onlineClient.setName("dsjf");
        onlineClient.setIsOpen(true);
        return onlineClientService.Insert(onlineClient);
    }

}