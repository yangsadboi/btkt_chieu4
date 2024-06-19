package com.example.trantiengiang.controller;

import com.example.trantiengiang.entity.NhanVien;
import com.example.trantiengiang.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    private final NhanVienRepository nhanVienRepository;

    @Autowired
    public HomeController(NhanVienRepository nhanVienRepository) {
        this.nhanVienRepository = nhanVienRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("nhanViens", nhanVienRepository.findAll());
        return "index";
    }

    @PostMapping("/add")
    public String addNhanVien(@ModelAttribute NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteNhanVien(@PathVariable Long id) {
        nhanVienRepository.deleteById(id);
        return "redirect:/";
    }
}
