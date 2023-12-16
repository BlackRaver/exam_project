package com.wsb.colector.models;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "RELICT")
public class Relict {

    @Id
    @Column(name = "RELICT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long relictID;

    @Column(name = "RELICT_NAME")
    private String name;

    @Column(name = "RELICT_TIER")
    private String tier;

    @OneToMany(mappedBy = "relict", cascade = CascadeType.ALL)
    private Set<RelictDropTable> drop = new HashSet<>();

    public Relict(String tier, String name) {//impotrant
        this.name = name;
        this.tier = tier;
    }

    public Relict(long relictID, String name, String tier, HashSet<RelictDropTable> drop) {
        this.relictID = relictID;
        this.name = name;
        this.tier = tier;
        this.drop = drop;
    }

    public Relict() {
    }

    public Relict(long relictID) {
        this.relictID = relictID;
    }


    public void addToDropTable(RelictDropTable primeItem) {
        drop.add(primeItem);
    }
}

