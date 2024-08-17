package com.restapi.company.dto;

import lombok.Data;

@Data
public class LokasiDTO {
    private Integer id;
    private String namaLokasi;
    private String negara;
    private String provinsi;
    private String kota;
}
