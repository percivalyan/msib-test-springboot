package com.restapi.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.restapi.company.entity.Lokasi;

public interface LokasiRepository extends JpaRepository<Lokasi, Integer> {
}
