package com.example.crm_amosys_orass.controller;
import com.example.crm_amosys_orass.dto.MetaDataDto;
import com.example.crm_amosys_orass.servise.impl.MetaDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/metad")
@CrossOrigin(origins ="*")
@RequiredArgsConstructor
public class MetaDataController {
    @Autowired
    private MetaDataService metaDataService;
    @GetMapping("/crm_metadata/{idClient}")
    public ResponseEntity<List<MetaDataDto>> getClientMetaData(@PathVariable long idClient){
        return new ResponseEntity<>(metaDataService.getMetaData(idClient), HttpStatus.OK);
    }
    @PostMapping("/create_crm_metadata")
    public ResponseEntity<List<MetaDataDto>> mergeMetaData(@RequestBody MetaDataDto metaDataDto){
        metaDataService.mergeMetaData(metaDataDto);
        return new ResponseEntity<>(metaDataService.getMetaData(metaDataDto.getIdClient()),HttpStatus.OK);
    }
}
