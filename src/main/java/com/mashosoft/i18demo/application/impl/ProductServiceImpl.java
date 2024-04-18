package com.mashosoft.i18demo.application.impl;

import com.mashosoft.i18demo.application.ProductService;
import com.mashosoft.i18demo.config.exceptionHandling.model.exception.BussinessExceptionWithTranslation;
import com.mashosoft.i18demo.domain.entity.Product;
import com.mashosoft.i18demo.domain.errorCodes.ErrorCodes;
import com.mashosoft.i18demo.domain.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public Product getProductById(String id){
        Product product = productRepository.getProductFromDatabaseById( id );
        if(product == null){
            throw new BussinessExceptionWithTranslation( ErrorCodes.ID_NOT_FOUND,new Object[]{id});
        }
        return product;
    }

    public List<Product> getAll() {
        List<Product> allProducts = productRepository.getAllFromDatabase();
        if(CollectionUtils.isEmpty( allProducts )){
            //Here the best option is to send a message saying that there are no products
            return null;
        }
        return allProducts;
    }
}
