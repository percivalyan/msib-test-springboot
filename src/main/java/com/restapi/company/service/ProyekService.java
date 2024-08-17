package com.restapi.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.company.dto.ProyekDTO;
import com.restapi.company.entity.Lokasi;
import com.restapi.company.entity.Proyek;
import com.restapi.company.repository.LokasiRepository;
import com.restapi.company.repository.ProyekRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProyekService {

    @Autowired
    private ProyekRepository proyekRepository;

    @Autowired
    private LokasiRepository lokasiRepository;

    public Proyek createProyek(ProyekDTO proyekDTO) {
        Proyek proyek = new Proyek();
        proyek.setNamaProyek(proyekDTO.getNamaProyek());
        proyek.setClient(proyekDTO.getClient());
        proyek.setTglMulai(proyekDTO.getTglMulai());
        proyek.setTglSelesai(proyekDTO.getTglSelesai());
        proyek.setPimpinanProyek(proyekDTO.getPimpinanProyek());
        proyek.setKeterangan(proyekDTO.getKeterangan());

        // Konversi List<Lokasi> menjadi Set<Lokasi>
        Set<Lokasi> lokasiSet = new HashSet<>(lokasiRepository.findAllById(proyekDTO.getLokasiIds()));
        proyek.setLokasiSet(lokasiSet);

        return proyekRepository.save(proyek);
    }

    public List<Proyek> getAllProyek() {
        return proyekRepository.findAll();
    }

    public Optional<Proyek> getProyekById(Integer id) {
        return proyekRepository.findById(id);
    }

    public Optional<Proyek> updateProyek(Integer id, ProyekDTO proyekDTO) {
        return proyekRepository.findById(id).map(proyek -> {
            proyek.setNamaProyek(proyekDTO.getNamaProyek());
            proyek.setClient(proyekDTO.getClient());
            proyek.setTglMulai(proyekDTO.getTglMulai());
            proyek.setTglSelesai(proyekDTO.getTglSelesai());
            proyek.setPimpinanProyek(proyekDTO.getPimpinanProyek());
            proyek.setKeterangan(proyekDTO.getKeterangan());

            // Konversi List<Lokasi> menjadi Set<Lokasi>
            Set<Lokasi> lokasiSet = new HashSet<>(lokasiRepository.findAllById(proyekDTO.getLokasiIds()));
            proyek.setLokasiSet(lokasiSet);

            return proyekRepository.save(proyek);
        });
    }

    public void deleteProyek(Integer id) {
        proyekRepository.deleteById(id);
    }
}
