// PhongBanRepository.java
package com.example.trantiengiang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.trantiengiang.entity.PhongBan;

public interface PhongBanRepository extends JpaRepository<PhongBan, Long> {
    // Các phương thức repository của bạn ở đây
}
