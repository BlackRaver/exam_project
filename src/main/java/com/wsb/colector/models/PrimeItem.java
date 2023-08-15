package com.wsb.colector.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name ="PRIME_ITEM")
public class PrimeItem {
    @Id
    @Column(name = "PRIME_ITEM_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prime_item_generator")
    @SequenceGenerator(name = "prime_item_generator", sequenceName = "prime_item_sequence_name", allocationSize = 1)
    private long elementID;

    @Column(name = "PRIME_ITEM_NAME")
    private String name;

    @Column(name = "PRIME_ITEM_VALUE")
    private int ducats;

    @JsonIgnore
    @ManyToMany(mappedBy = "drop")
    private Set<Relict> relicts = new HashSet<>();

    public PrimeItem(String name, int ducats) {
        this.name = name;
        this.ducats = ducats;
    }

    public PrimeItem(long elementID, String name, int ducats, Set<Relict> relicts) {
        this.elementID = elementID;
        this.name = name;
        this.ducats = ducats;
        this.relicts = relicts;
    }

    public PrimeItem() {
    }

    public long getElementID() {
        return elementID;
    }

    public void setElementID(long elementID) {
        this.elementID = elementID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDucats() {
        return ducats;
    }

    public void setDucats(int ducats) {
        this.ducats = ducats;
    }

    public Set<Relict> getRelicts() {
        return relicts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrimeItem primeItem = (PrimeItem) o;
        return elementID == primeItem.elementID && ducats == primeItem.ducats && Objects.equals(name, primeItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elementID, name, ducats);
    }

    @Override
    public String toString() {
        return "PrimeItem{" +
                "elementID=" + elementID +
                ", name='" + name + '\'' +
                ", ducats=" + ducats +
                '}';
    }
}
