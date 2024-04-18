package com.mashosoft.i18demo.infrastructure.db.adapter;

import com.mashosoft.i18demo.domain.entity.Product;
import com.mashosoft.i18demo.domain.repository.ProductRepository;
import com.mashosoft.i18demo.infrastructure.db.adapter.mapper.ProductDbMapper;
import com.mashosoft.i18demo.infrastructure.db.entity.ProductSQL;
import com.mashosoft.i18demo.infrastructure.db.repository.ProductJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductDbMapper mapper;
    private final ProductJpaRepository productJpaRepository;

    @Override
    public Product getProductFromDatabaseById(String id) {
        ProductSQL productSQL = productJpaRepository.findbyId( id );
        return mapper.fromDbToDomain( productSQL );
    }

    @Override
    public List<Product> getAllFromDatabase() {
        List<ProductSQL> allProductsSql = productJpaRepository.findAll();
        return mapper.fromDbToDomain( allProductsSql );
    }
}
