package com.mashosoft.i18demo.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Catalog {

    private String code;

    private String type;

    private String description_en;

    private String description_es;

    private String description_de;

    public static Catalog filterListByCode(List<Catalog> catalogs,String code){
        Optional<Catalog> typeCode = catalogs.stream().filter( catalog -> catalog.getCode().equals( code ) ).findFirst();
        return typeCode.orElse( null );
    }

    public static Catalog filterListByTypeAndCode(List<Catalog> catalogs,String type,String code){
        Optional<Catalog> typeCode = catalogs.stream()
            .filter( catalog -> catalog.getCode().equals( code ) && catalog.getType().equals( type ) )
            .findFirst();
        return typeCode.orElse( null );
    }
}
