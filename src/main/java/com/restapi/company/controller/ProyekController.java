package com.restapi.company.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.restapi.company.dto.ProyekDTO;
import com.restapi.company.entity.Lokasi;
import com.restapi.company.entity.Proyek;
import com.restapi.company.service.ProyekService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/proyek")
public class ProyekController {

    @Autowired
    private ProyekService proyekService;

    @PostMapping
    public ResponseEntity<Proyek> createProyek(@RequestBody ProyekDTO proyekDTO) {
        return ResponseEntity.ok(proyekService.createProyek(proyekDTO));
    }

    @GetMapping
    public ResponseEntity<List<Proyek>> getAllProyek() {
        return ResponseEntity.ok(proyekService.getAllProyek());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProyekById(@PathVariable Integer id) {
        Optional<Proyek> proyek = proyekService.getProyekById(id);
        if (proyek.isPresent()) {
            return ResponseEntity.ok(proyek.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No project found with the specified ID: " + id);
        }
    }

    @GetMapping("/{id}/lokasi")
    public ResponseEntity<List<Lokasi>> getLokasiByProyekId(@PathVariable Integer id) {
        return ResponseEntity.ok(proyekService.getLokasiByProyekId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proyek> updateProyek(@PathVariable Integer id, @RequestBody ProyekDTO proyekDTO) {
        return proyekService.updateProyek(id, proyekDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProyek(@PathVariable Integer id) {
        proyekService.deleteProyek(id);
        return ResponseEntity.ok("Successfully deleted the project with ID: " + id);
    }
}