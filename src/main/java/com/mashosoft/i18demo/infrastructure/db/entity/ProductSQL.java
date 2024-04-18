package com.mashosoft.i18demo.infrastructure.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "product")
public class ProductSQL {

    @Id
    private String id;

    private String code;

    private String brand;

    private Double cost;
}
