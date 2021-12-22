package ru.stankin.bd.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "broadcast")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BroadcastEntity {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "ky")
    private Double ky;

    @Column(name = "kv")
    private Double kv;

    @Column(name = "kd")
    private Double kd;

    @Column(name = "kz")
    private Double kz;

    @Column(name = "k_t")
    private Double k_t;

    @Column(name = "km")
    private Double km;

    @Column(name = "kt")
    private Double kt;
}