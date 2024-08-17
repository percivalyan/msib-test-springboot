package com.restapi.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.restapi.company.entity.Proyek;

public interface ProyekRepository extends JpaRepository<Proyek, Integer> {
}
