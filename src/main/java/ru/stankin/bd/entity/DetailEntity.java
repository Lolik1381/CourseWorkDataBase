package ru.stankin.bd.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detail")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DetailEntity {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "broadcast_id", nullable = false)
    private BroadcastEntity broadcastEntity;

    @Column(name = "z1")
    private Double z1;

    @Column(name = "n1")
    private Double n1;

    @Column(name = "tz")
    private Double tz;

    @Column(name = "n")
    private Double n;

    @Column(name = "t")
    private Double t;

    @Column(name = "pys")
    private Double pys;

    @Column(name = "sop")
    private Double sop;

    @Column(name = "yz")
    private Double yz;

    @Column(name = "feu")
    private Double feu;

    @Column(name = "fi")
    private Double fi;

    @Column(name = "ni")
    private Double ni;

    @Column(name = "tzi")
    private Double tzi;

    @Column(name = "k")
    private Double k;
}