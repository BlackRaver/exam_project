package com.wsb.colector.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "RELICT_DROP_TABLE")
public class RelictDropTable {

    @Id
    @Column(name ="RELICT_DROP_TABLE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

//    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PRIME_ITEM_ID")
    private PrimeItem primeItem;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RELICT_ID")
    private Relict relict;

    @Column(name ="RARITY")
    private String rarity;

    public RelictDropTable(PrimeItem primeItem, Relict relict, String rarity) {
        this.primeItem = primeItem;
        this.relict = relict;
        this.rarity = rarity;
    }

}
