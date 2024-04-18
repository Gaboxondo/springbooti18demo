package com.mashosoft.i18demo.infrastructure.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CatalogIdSQL {

    @Column
    private String code;

    @Column
    private String type;
}
