package com.restapi.company.dto;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class ProyekDTO {
    private Integer id;
    private String namaProyek;
    private String client;
    private LocalDateTime tglMulai;
    private LocalDateTime tglSelesai;
    private String pimpinanProyek;
    private String keterangan;
    private Set<Integer> lokasiIds;
}
