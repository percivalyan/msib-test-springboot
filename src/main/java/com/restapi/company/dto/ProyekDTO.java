package com.restapi.company.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.Set;

@Data
public class ProyekDTO {
    private Integer id;
    private String namaProyek;
    private String client;
    private LocalDate tglMulai;
    private LocalDate tglSelesai;
    private String pimpinanProyek;
    private String keterangan;
    private Set<Integer> lokasiIds;
}
