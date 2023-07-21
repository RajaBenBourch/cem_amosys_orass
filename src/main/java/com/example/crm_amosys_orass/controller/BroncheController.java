package com.example.crm_amosys_orass.controller;
import com.example.crm_amosys_orass.dto.BroncheDto;
import com.example.crm_amosys_orass.mapper.BroncheMapper;
import com.example.crm_amosys_orass.servise.impl.BroncheService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/bronch")
@RequiredArgsConstructor
public class BroncheController {
    @Autowired
    private BroncheService broncheService;
    @GetMapping("/crm_bronche")
    public ResponseEntity<List<BroncheDto>> getAll(){
        return new ResponseEntity<>(broncheService.getAll(), HttpStatus.OK);

    }

}
