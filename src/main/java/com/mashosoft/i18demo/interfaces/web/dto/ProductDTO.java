package com.mashosoft.i18demo.interfaces.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {

    @Schema(description = "The Id of the product")
    private String id;

    @Schema(description = "The product type in a catalog code and description")
    private CatalogDTO type;

    @Schema(description = "The product brand or manufacturer")
    private String brand;

    @Schema(description = "cost of the product")
    private Double cost;

    @Schema(description = "The product quality in a catalog code and description")
    private CatalogDTO quality;
}
