package ru.stankin.bd.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Database {

    private String id;
    private Double ky;
    private Double kv;
    private Double kd;
    private Double kz;
    private Double k_t;
    private Double km;
    private Double kt;
    private Double z1;
    private Double n1;
    private Double tz;
    private Double n;
    private Double t;
    private Double pys;
    private Double sop;
    private Double yz;
    private Double feu;
    private Double fi;
    private Double ni;
    private Double tzi;
    private Double k;
}