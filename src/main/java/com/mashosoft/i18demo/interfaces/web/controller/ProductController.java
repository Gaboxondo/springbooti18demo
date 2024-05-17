package com.mashosoft.i18demo.interfaces.web.controller;

import com.mashosoft.i18demo.config.exceptionHandling.handler.model.ControlledErrorResponse;
import com.mashosoft.i18demo.config.openApi.OpenApiProperties;
import com.mashosoft.i18demo.interfaces.web.adapter.ProductWebInterfaceAdapter;
import com.mashosoft.i18demo.interfaces.web.dto.ProductDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private final ProductWebInterfaceAdapter productWebInterfaceAdapter;

    @RequestMapping(
        value = "v1",
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.GET)
    @Operation(description="Get all products from database")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "500", content = @Content(schema = @Schema(implementation = ControlledErrorResponse.class)), description = OpenApiProperties.GENERIC_ERROR_DEF),
        @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(implementation = ControlledErrorResponse.class)), description = OpenApiProperties.BAD_REQUEST_DEF)})
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> getAllProducts() {
        return productWebInterfaceAdapter.getAllProducts(  );
    }

    @RequestMapping(
        value = "v1/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.GET)
    @Operation(description="Get one product by Id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "500", content = @Content(schema = @Schema(implementation = ControlledErrorResponse.class)), description = OpenApiProperties.GENERIC_ERROR_DEF),
        @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(implementation = ControlledErrorResponse.class)), description = OpenApiProperties.BAD_REQUEST_DEF)})
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO getProductById(@PathVariable("id") String productId) {
        return productWebInterfaceAdapter.getProductById( productId );
    }
}
