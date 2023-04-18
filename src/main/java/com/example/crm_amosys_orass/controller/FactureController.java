package com.example.crm_amosys_orass.controller;

import com.example.crm_amosys_orass.dto.FactureDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("factures")
public class FactureController {
    @PostMapping
    public String create(@RequestBody FactureDTO factureDto) {
        return "";
    }
}
