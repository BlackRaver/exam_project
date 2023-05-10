package com.wsb.colector.models;


import lombok.*;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Relict {

    private UUID id_relict;
    private String name;
    private String common1;


}
