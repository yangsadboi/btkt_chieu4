package com.example.trantiengiang.services;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageService {

    // Đường dẫn thư mục lưu trữ file
    private static final String UPLOAD_DIR = "./utils/uploads";

    @PostConstruct
    public void init() {
        try {
            // Tạo thư mục uploads nếu chưa tồn tại
            Path path = Paths.get(UPLOAD_DIR);
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }
        } catch (Exception e) {
            throw new RuntimeException("Không thể khởi tạo thư mục lưu trữ", e);
        }
    }

    public String getUploadDir() {
        return UPLOAD_DIR;
    }
}
