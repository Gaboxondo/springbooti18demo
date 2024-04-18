package com.mashosoft.i18demo.interfaces.web.adapter.mapper;

import com.mashosoft.i18demo.domain.entity.Product;
import com.mashosoft.i18demo.interfaces.web.adapter.translator.DtoLiteralsFiller;
import com.mashosoft.i18demo.interfaces.web.dto.CatalogDTO;
import com.mashosoft.i18demo.interfaces.web.dto.ProductDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class ProductDtoMapper {

    public ProductDTO fromDomainToDTO(Product product){
        return new ProductDTO(product.getId(),new CatalogDTO( product.getCode(), null), product.getBrand(),
            product.getCost() ) ;
    }

    public List<ProductDTO> fromDomainToDTO(List<Product> products){
        if(CollectionUtils.isEmpty( products )){
            return null;
        }
        return products.stream().map( this::fromDomainToDTO ).collect( Collectors.toList());
    }
}
