package com.example.trantiengiang.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@Table(name = "nhanvien")
public class NhanVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ma_NV")
    private Long id;

    @Column(name = "Ten_NV", nullable = false, length = 50)
    @NotEmpty(message = "Tên nhân viên không được để trống")
    @Size(min = 1, max = 50, message = "Tên nhân viên phải từ 1 đến 50 ký tự")
    private String tenNV;

    @Column(name = "Phai", nullable = false)
    @NotEmpty(message = "Phái không được để trống")
    private String phai;

    @Column(name = "Noi_Sinh", nullable = false)
    @NotEmpty(message = "Nơi sinh không được để trống")
    private String noiSinh;

    @Column(name = "Luong", nullable = false)
    @NotNull(message = "Lương là bắt buộc")
    private Double luong;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Ma_Phong", nullable = false)
    @ToString.Exclude
    private PhongBan phongBan;

    @Column(name = "Image_Url")
    private String imageUrl; // Thêm trường để lưu đường dẫn ảnh

    // Constructors, getters, setters
    // Vui lòng tạo các phương thức getter và setter cho các trường của đối tượng NhanVien

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getPhai() {
        return phai;
    }

    public void setPhai(String phai) {
        this.phai = phai;
    }

    public String getNoiSinh() {
        return noiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }

    public Double getLuong() {
        return luong;
    }

    public void setLuong(Double luong) {
        this.luong = luong;
    }

    public PhongBan getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(PhongBan phongBan) {
        this.phongBan = phongBan;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
