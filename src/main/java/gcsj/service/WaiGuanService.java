package gcsj.service;

import gcsj.entity.WaiGuan;
import org.springframework.ui.Model;

import java.util.List;

public interface WaiGuanService {
    List<WaiGuan> getWaiguanList();
    String showMenu(Model model);
}
