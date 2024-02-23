package com.example.electrostore.controller;

import com.example.electrostore.services.imp.FileSaveImp;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/file")
public class FileController {

    @Autowired
    private FileSaveImp fileSaveImp;

    @PostMapping ("upload")
    public ResponseEntity<?> saveFile(@RequestParam MultipartFile image){
        fileSaveImp.saveImage(image);
        return new ResponseEntity<>("Insert suscessfull", HttpStatus.OK);
    }

    @GetMapping("/{imageName}")
    ResponseEntity<?> downloadFile(@PathVariable String imageName){
        Resource resource = fileSaveImp.load(imageName);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename\"" + imageName + "\"")
                .body(resource);
    }
}
