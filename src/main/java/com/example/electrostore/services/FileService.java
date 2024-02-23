package com.example.electrostore.services;

import com.example.electrostore.services.imp.FileSaveImp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService implements FileSaveImp {

    @Value("/Users/giangtruong/Desktop/uploads")
    private String root;

    @Override
    public void saveImage(MultipartFile image) {
        Path imagePath = Paths.get(root);
        try{
            if(!Files.exists(imagePath)){
                Files.createDirectories(imagePath);
            }
            Files.copy(image.getInputStream(), imagePath.resolve(image.getOriginalFilename()));
        }
        catch (Exception e){
            throw new RuntimeException("File Error!" + e.getMessage());
        }

    }

    @Override
    public Resource load(String imageName) {
        try{
            Path pathImage = Paths.get(root).resolve(imageName);
            Resource resource = new UrlResource(pathImage.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }else {
                throw new RuntimeException("File does not exists!");
            }
        }catch(Exception e){
            throw new RuntimeException("File does not exists!" + e.getMessage());
        }
    }
}
