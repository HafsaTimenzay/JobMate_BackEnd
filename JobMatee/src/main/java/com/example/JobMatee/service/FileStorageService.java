package com.example.JobMatee.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

//@Service
//public class FileUploadService {
//    public String uploadFile(MultipartFile file) {
//        String uploadDir = "uploads/";
//        File directory = new File(uploadDir);
//        if (!directory.exists()) {
//            directory.mkdirs(); // Create the directory if it doesn't exist
//        }
//
//        String filePath = uploadDir + file.getOriginalFilename();
//        try {
//            Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            throw new RuntimeException("Failed to upload file", e);
//        }
//        return filePath;
//    }
//}
@Service
public class FileStorageService {



    private final Path storagePath;

    public FileStorageService(@Value("${file.upload-dir}") String uploadDir) {
        this.storagePath = Paths.get(uploadDir).toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.storagePath);
        } catch (IOException e) {
            throw new RuntimeException("Could not create upload directory!", e);
        }
    }

//    public String saveFile(MultipartFile file) {
//        try {
//            String fileName = file.getOriginalFilename();
//            if (fileName == null) {
//                throw new RuntimeException("Invalid file name!");
//            }
//
//            // Generate a unique file name to avoid collisions
//            String uniqueFileName = UUID.randomUUID().toString() + "_" + fileName;
//
//            Path targetLocation = this.storagePath.resolve(uniqueFileName);
//            Files.copy(file.getInputStream(), targetLocation);
//            return uniqueFileName; // Return the unique file name
//        } catch (IOException e) {
//            throw new RuntimeException("Could not store file. Error: " + e.getMessage());
//        }
//    }

    public Path getFilePath(String fileName) {
        return this.storagePath.resolve(fileName).normalize();
}

    private final String uploadDir = "uploads/resumes/";

    public String saveFile(MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path path = Paths.get(uploadDir + fileName);
        Files.createDirectories(path.getParent());
        Files.write(path, file.getBytes());
        return path.toString();
    }
}


