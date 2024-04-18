package com.mashosoft.i18demo.infrastructure.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "catalog")
public class CatalogSQL {

    @EmbeddedId
    private CatalogIdSQL id;

    @Column
    private String description_en;

    @Column
    private String description_es;

    @Column
    private String description_de;
}
