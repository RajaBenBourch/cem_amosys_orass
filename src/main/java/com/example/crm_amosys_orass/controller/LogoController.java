package com.example.crm_amosys_orass.controller;
import com.example.crm_amosys_orass.servise.impl.LogoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/logo")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class LogoController {
    @Autowired
    private LogoService logoService;
    @GetMapping("/{fileName}")
    public ResponseEntity<?> downloadImage(@PathVariable String fileName){
        byte[] file=logoService.downloadImage(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(file);
    }
}
