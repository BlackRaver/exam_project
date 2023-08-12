package com.wsb.colector.models;


import jakarta.persistence.*;
import lombok.*;

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
    private int tier;

    @ManyToMany
    @JoinTable(
            name="RELICT_DROP_TABLE",
            joinColumns = @JoinColumn(name="RELICT_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRIME_ITEM_ID")
    )
    private Set<PrimeItem> drop = new HashSet<>();

    public long getRelictID() {
        return relictID;
    }

    public void setRelictID(long relictID) {
        this.relictID = relictID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public Set<PrimeItem> getDrop() {
        return drop;
    }
    public Relict(String name, int tier, PrimeItem c1) {
        this.name = name;
        this.tier = tier;
    }

    public Relict(long relictID, String name, int tier, Set<PrimeItem> drop) {
        this.relictID = relictID;
        this.name = name;
        this.tier = tier;
        this.drop = drop;
    }

    public Relict() {
    }

    public void addToDropTable(PrimeItem primeItem) {
        drop.add(primeItem);
    }
}
