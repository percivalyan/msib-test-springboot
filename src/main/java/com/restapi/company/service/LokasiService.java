package com.restapi.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.company.dto.LokasiDTO;
import com.restapi.company.entity.Lokasi;
import com.restapi.company.repository.LokasiRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LokasiService {

    @Autowired
    private LokasiRepository lokasiRepository;

    public Lokasi createLokasi(LokasiDTO lokasiDTO) {
        Lokasi lokasi = new Lokasi();
        lokasi.setNamaLokasi(lokasiDTO.getNamaLokasi());
        lokasi.setNegara(lokasiDTO.getNegara());
        lokasi.setProvinsi(lokasiDTO.getProvinsi());
        lokasi.setKota(lokasiDTO.getKota());
        return lokasiRepository.save(lokasi);
    }

    public List<Lokasi> getAllLokasi() {
        return lokasiRepository.findAll();
    }

    public Optional<Lokasi> updateLokasi(Integer id, LokasiDTO lokasiDTO) {
        return lokasiRepository.findById(id).map(lokasi -> {
            lokasi.setNamaLokasi(lokasiDTO.getNamaLokasi());
            lokasi.setNegara(lokasiDTO.getNegara());
            lokasi.setProvinsi(lokasiDTO.getProvinsi());
            lokasi.setKota(lokasiDTO.getKota());
            return lokasiRepository.save(lokasi);
        });
    }

    public void deleteLokasi(Integer id) {
        lokasiRepository.deleteById(id);
    }
}
