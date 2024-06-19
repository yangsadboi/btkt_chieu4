package com.example.trantiengiang.util;

import com.example.trantiengiang.services.FileStorageService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class FileUploadUtil {

    // Lấy thư mục lưu trữ từ service
    private static final String UPLOAD_DIR = new FileStorageService().getUploadDir();

    public static void saveFile(MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_DIR + "/" + generateFileName(file.getOriginalFilename()));
            Files.write(path, bytes);
        }
    }

    // Phương thức sinh ra tên file duy nhất
    private static String generateFileName(String originalFileName) {
        return UUID.randomUUID().toString() + "_" + originalFileName;
    }
}
