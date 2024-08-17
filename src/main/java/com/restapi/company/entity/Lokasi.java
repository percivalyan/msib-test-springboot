package com.restapi.company.entity;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "lokasi")
public class Lokasi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nama_lokasi", nullable = false)
    private String namaLokasi;

    @Column(name = "negara", nullable = false)
    private String negara;

    @Column(name = "provinsi", nullable = false)
    private String provinsi;

    @Column(name = "kota", nullable = false)
    private String kota;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
