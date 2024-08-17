package com.restapi.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.restapi.company.dto.LokasiDTO;
import com.restapi.company.entity.Lokasi;
import com.restapi.company.service.LokasiService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/lokasi")
public class LokasiController {

    @Autowired
    private LokasiService lokasiService;

    @PostMapping
    public ResponseEntity<Lokasi> createLokasi(@RequestBody LokasiDTO lokasiDTO) {
        return ResponseEntity.ok(lokasiService.createLokasi(lokasiDTO));
    }

    @GetMapping
    public ResponseEntity<List<Lokasi>> getAllLokasi() {
        return ResponseEntity.ok(lokasiService.getAllLokasi());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lokasi> getLokasiById(@PathVariable Integer id) {
        return lokasiService.getLokasiById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lokasi> updateLokasi(@PathVariable Integer id, @RequestBody LokasiDTO lokasiDTO) {
        return lokasiService.updateLokasi(id, lokasiDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLokasi(@PathVariable Integer id) {
        lokasiService.deleteLokasi(id);
        return ResponseEntity.noContent().build();
    }
}
