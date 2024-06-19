package com.example.trantiengiang.controller;

import com.example.trantiengiang.entity.PhongBan;
import com.example.trantiengiang.services.PhongBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/phongban")
public class PhongBanController {

    private final PhongBanService phongBanService;

    @Autowired
    public PhongBanController(PhongBanService phongBanService) {
        this.phongBanService = phongBanService;
    }

    @GetMapping
    public String listPhongBan(Model model) {
        model.addAttribute("phongBans", phongBanService.getAllPhongBans());
        return "phongban/list";
    }

    @GetMapping("/{id}")
    public String getPhongBan(@PathVariable Long id, Model model) {
        model.addAttribute("phongBan", phongBanService.getPhongBanById(id));
        return "phongban/detail";
    }

    @PostMapping
    public String addPhongBan(@ModelAttribute PhongBan phongBan) {
        phongBanService.savePhongBan(phongBan);
        return "redirect:/phongban";
    }

    @DeleteMapping("/{id}")
    public String deletePhongBan(@PathVariable Long id) {
        phongBanService.deletePhongBan(id);
        return "redirect:/phongban";
    }
}
