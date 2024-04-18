package com.mashosoft.i18demo.interfaces.web.adapter.impl;

import com.mashosoft.i18demo.application.ProductService;
import com.mashosoft.i18demo.application.impl.ProductServiceImpl;
import com.mashosoft.i18demo.domain.entity.Product;
import com.mashosoft.i18demo.interfaces.web.adapter.ProductWebInterfaceAdapter;
import com.mashosoft.i18demo.interfaces.web.adapter.mapper.ProductDtoMapper;
import com.mashosoft.i18demo.interfaces.web.adapter.translator.DtoLiteralsFiller;
import com.mashosoft.i18demo.interfaces.web.dto.ProductDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class ProductInterfaceAdapterImpl implements ProductWebInterfaceAdapter {

    private final ProductService productService;
    private final ProductDtoMapper productDtoMapper;
    private final DtoLiteralsFiller dtoLiteralsFiller;

    public ProductDTO getProductById(String id){
        Product product = productService.getProductById( id );
        ProductDTO productDTO = productDtoMapper.fromDomainToDTO( product );
        dtoLiteralsFiller.addDescriptions( productDTO );
        return productDTO;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productService.getAll();
        List<ProductDTO> productDTOS = productDtoMapper.fromDomainToDTO( products );
        dtoLiteralsFiller.addDescriptions( productDTOS );
        return productDTOS;
    }
}
