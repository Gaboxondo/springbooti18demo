package com.mashosoft.i18demo.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private String id;

    private String typeCode;

    private String brand;

    private Double cost;

    private String qualityCode;
}
