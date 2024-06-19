package com.example.trantiengiang.services;

import com.example.trantiengiang.entity.NhanVien;
import com.example.trantiengiang.entity.PhongBan;
import com.example.trantiengiang.repository.NhanVienRepository;
import com.example.trantiengiang.repository.PhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienService {

    private final NhanVienRepository nhanVienRepository;
    private final PhongBanRepository phongBanRepository;

    @Autowired
    public NhanVienService(NhanVienRepository nhanVienRepository, PhongBanRepository phongBanRepository) {
        this.nhanVienRepository = nhanVienRepository;
        this.phongBanRepository = phongBanRepository;
    }

    public List<NhanVien> getAllNhanViens() {
        return nhanVienRepository.findAll();
    }

    public NhanVien getNhanVienById(Long id) {
        return nhanVienRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy nhân viên có ID = " + id));
    }

    public void addNhanVien(NhanVien nhanVien) {
        if (validateNhanVien(nhanVien)) {
            nhanVienRepository.save(nhanVien);
        } else {
            throw new IllegalArgumentException("Thông tin nhân viên không hợp lệ");
        }
    }

    public void updateNhanVien(NhanVien nhanVien) {
        if (validateNhanVien(nhanVien)) {
            NhanVien existingNhanVien = nhanVienRepository.findById(nhanVien.getId())
                    .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy nhân viên có ID = " + nhanVien.getId()));
            existingNhanVien.setTenNV(nhanVien.getTenNV());
            existingNhanVien.setPhai(nhanVien.getPhai());
            existingNhanVien.setNoiSinh(nhanVien.getNoiSinh());
            existingNhanVien.setLuong(nhanVien.getLuong());
            existingNhanVien.setPhongBan(nhanVien.getPhongBan());
            nhanVienRepository.save(existingNhanVien);
        } else {
            throw new IllegalArgumentException("Thông tin nhân viên không hợp lệ");
        }
    }

    public void deleteNhanVien(Long id) {
        NhanVien nhanVien = nhanVienRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy nhân viên có ID = " + id));
        nhanVienRepository.delete(nhanVien);
    }

    public List<PhongBan> getAllPhongBans() {
        return phongBanRepository.findAll();
    }

    private boolean validateNhanVien(NhanVien nhanVien) {
        return nhanVien != null &&
                nhanVien.getTenNV() != null &&
                !nhanVien.getTenNV().isEmpty() &&
                nhanVien.getPhongBan() != null &&
                nhanVien.getPhongBan().getMaPhong() != null;
    }
}
