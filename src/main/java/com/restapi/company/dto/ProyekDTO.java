package com.restapi.company.dto;

import lombok.Data;
import java.util.Date;
import java.util.Set;

@Data
public class ProyekDTO {
    private Integer id;
    private String namaProyek;
    private String client;
    private Date tglMulai;
    private Date tglSelesai;
    private String pimpinanProyek;
    private String keterangan;
    private Set<Integer> lokasiIds;
}
