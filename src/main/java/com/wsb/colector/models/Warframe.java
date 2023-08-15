package com.wsb.colector.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name ="WARFRAME")
public class Warframe{

    @Id
    @Column(name = "WARFRAME_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long frameID;

    @Column(name = "NAME")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MAIN_BP")
    private PrimeItem blMain;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "NEUROPTICS_BP")
    private PrimeItem blNeuroptics;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CHASSIS_BP")
    private PrimeItem blChassis;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SYSTEM_BP")
    private PrimeItem blSystems;

    public Warframe(String name, PrimeItem blMain, PrimeItem blNeuroptics, PrimeItem blChassis, PrimeItem blSystems) {
        this.name = name;
        this.blMain = blMain;
        this.blNeuroptics = blNeuroptics;
        this.blChassis = blChassis;
        this.blSystems = blSystems;
    }

    public Warframe() {
    }
}
