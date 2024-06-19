package com.example.trantiengiang.controller;

import com.example.trantiengiang.entity.NhanVien;
import com.example.trantiengiang.services.NhanVienService;
import com.example.trantiengiang.services.PhongBanService;
import com.example.trantiengiang.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/nhanvien")
public class NhanVienController {

    private final NhanVienService nhanVienService;
    private final PhongBanService phongBanService;

    @Autowired
    public NhanVienController(NhanVienService nhanVienService, PhongBanService phongBanService) {
        this.nhanVienService = nhanVienService;
        this.phongBanService = phongBanService;
    }

    @GetMapping
    public String listNhanVien(Model model) {
        List<NhanVien> nhanViens = nhanVienService.getAllNhanViens();
        model.addAttribute("nhanViens", nhanViens);
        return "nhanvien/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("nhanVien", new NhanVien());
        model.addAttribute("phongBans", phongBanService.getAllPhongBans());
        return "nhanvien/add";
    }

    @PostMapping("/add")
    public String addNhanVien(@ModelAttribute("nhanVien") NhanVien nhanVien,
                              @RequestParam("imageFile") MultipartFile imageFile) throws IOException {
        if (!imageFile.isEmpty()) {
            String imageUrl = "/images/" + imageFile.getOriginalFilename(); // Đường dẫn lưu ảnh
            nhanVien.setImageUrl(imageUrl);
            nhanVienService.addNhanVien(nhanVien);
            FileUploadUtil.saveFile(imageFile);
        }
        return "redirect:/nhanvien";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        NhanVien nhanVien = nhanVienService.getNhanVienById(id);
        model.addAttribute("nhanVien", nhanVien);
        model.addAttribute("phongBans", phongBanService.getAllPhongBans());
        return "nhanvien/edit";
    }

    @PostMapping("/edit/{id}")
    public String editNhanVien(@PathVariable Long id, @ModelAttribute("nhanVien") NhanVien nhanVien,
                               @RequestParam(value = "imageFile", required = false) MultipartFile imageFile) throws IOException {
        if (imageFile != null && !imageFile.isEmpty()) {
            String imageUrl = "/images/" + imageFile.getOriginalFilename(); // Đường dẫn lưu ảnh
            nhanVien.setImageUrl(imageUrl);
            FileUploadUtil.saveFile(imageFile);
        }
        nhanVien.setId(id);
        nhanVienService.updateNhanVien(nhanVien);
        return "redirect:/nhanvien";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteNhanVien(@PathVariable Long id) {
        nhanVienService.deleteNhanVien(id);
        return "redirect:/nhanvien";
    }
}
