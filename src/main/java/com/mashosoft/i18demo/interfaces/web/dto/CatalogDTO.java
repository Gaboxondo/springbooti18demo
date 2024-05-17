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
public class CatalogDTO {

    @Schema(description = "The catalog code of the specific type")
    private String code;

    @Schema(description = "The translated name description of this literal")
    private String description;
}
