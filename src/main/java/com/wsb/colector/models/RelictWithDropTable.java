package com.wsb.colector.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class RelictWithDropTable {
    private Relict relict;
    private List<RelictDropTable> dropList;

}
