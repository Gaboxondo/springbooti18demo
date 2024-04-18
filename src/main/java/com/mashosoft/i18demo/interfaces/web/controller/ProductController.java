package com.mashosoft.i18demo.interfaces.web.controller;

import com.mashosoft.i18demo.interfaces.web.adapter.ProductWebInterfaceAdapter;
import com.mashosoft.i18demo.interfaces.web.adapter.impl.ProductInterfaceAdapterImpl;
import com.mashosoft.i18demo.interfaces.web.dto.ProductDTO;
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
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> getAllProducts() {
        return productWebInterfaceAdapter.getAllProducts(  );
    }

    @RequestMapping(
        value = "v1/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO getProductById(@PathVariable("id") String productId) {
        return productWebInterfaceAdapter.getProductById( productId );
    }
}
