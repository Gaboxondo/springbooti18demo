package com.mashosoft.i18demo.infrastructure.db.adapter.mapper;

import com.mashosoft.i18demo.domain.entity.Product;
import com.mashosoft.i18demo.infrastructure.db.entity.ProductSQL;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductDbMapper {

    public Product fromDbToDomain(ProductSQL productSQL){
        if(productSQL == null){
            return null;
        }
        return new Product(productSQL.getId(), productSQL.getCode(), productSQL.getBrand(), productSQL.getCost() );
    }

    public List<Product> fromDbToDomain(List<ProductSQL> productSQL){
        if(CollectionUtils.isEmpty( productSQL )){
            return null;
        }
        return productSQL.stream().map( this::fromDbToDomain ).collect( Collectors.toList());
    }
}
