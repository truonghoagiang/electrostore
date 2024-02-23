package com.example.electrostore.services.imp;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FileSaveImp {

    void saveImage(MultipartFile image);

    public Resource load(String imageName);
}
