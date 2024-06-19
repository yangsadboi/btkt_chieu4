package com.example.trantiengiang.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "phongban")
public class PhongBan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ma_Phong")
    private Long maPhong;

    @Column(name = "Ten_Phong", nullable = false, length = 50)
    @NotEmpty(message = "Ten_Phong không được để trống")
    @Size(min = 1, max = 50, message = "Ten_Phong phải từ 1 đến 50 ký tự")
    private String tenPhong;

    @OneToMany(mappedBy = "phongBan", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<NhanVien> nhanViens;

    // Constructors
    public PhongBan(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    // Getter and setter for tenPhong
    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    // Getter and setter for nhanViens
    public List<NhanVien> getNhanViens() {
        return nhanViens;
    }

    public void setNhanViens(List<NhanVien> nhanViens) {
        this.nhanViens = nhanViens;
    }

    // Getter for maPhong
    public Long getMaPhong() {
        return maPhong;
    }
}
