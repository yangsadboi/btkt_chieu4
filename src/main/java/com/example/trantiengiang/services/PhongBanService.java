package com.example.trantiengiang.services;

import com.example.trantiengiang.entity.PhongBan;
import com.example.trantiengiang.repository.PhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhongBanService {

    private final PhongBanRepository phongBanRepository;

    @Autowired
    public PhongBanService(PhongBanRepository phongBanRepository) {
        this.phongBanRepository = phongBanRepository;
    }

    public List<PhongBan> getAllPhongBans() {
        return phongBanRepository.findAll();
    }

    public PhongBan getPhongBanById(Long id) {
        return phongBanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Phòng ban không tồn tại"));
    }

    public PhongBan savePhongBan(PhongBan phongBan) {
        return phongBanRepository.save(phongBan);
    }

    public void deletePhongBan(Long id) {
        if (phongBanRepository.existsById(id)) {
            phongBanRepository.deleteById(id);
        } else {
            throw new RuntimeException("Phòng ban không tồn tại");
        }
    }
}
