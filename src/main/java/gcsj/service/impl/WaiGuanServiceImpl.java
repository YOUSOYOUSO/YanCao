package gcsj.service.impl;

import gcsj.entity.WaiGuan;
import gcsj.repository.WaiGuanRepository;
import gcsj.service.WaiGuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class WaiGuanServiceImpl implements WaiGuanService {

    @Autowired
    WaiGuanRepository waiGuanRepository;

    @Override
    public List<WaiGuan> getWaiguanList() {
        return waiGuanRepository.findAll();
    }
    public String showMenu(Model model){
//        List<Menu> menuList =  menuMapper.selectMenu();
        List<WaiGuan> waiguanList = waiGuanRepository.findAll();
        model.addAttribute("waiguanList",waiguanList);
        return "index2";
    }
}
