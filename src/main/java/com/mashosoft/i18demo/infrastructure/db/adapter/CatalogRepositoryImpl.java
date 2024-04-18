package com.mashosoft.i18demo.infrastructure.db.adapter;

import com.mashosoft.i18demo.domain.entity.Catalog;
import com.mashosoft.i18demo.domain.entity.Product;
import com.mashosoft.i18demo.domain.repository.CatalogRepository;
import com.mashosoft.i18demo.infrastructure.db.adapter.mapper.CatalogDbMapper;
import com.mashosoft.i18demo.infrastructure.db.entity.CatalogSQL;
import com.mashosoft.i18demo.infrastructure.db.entity.ProductSQL;
import com.mashosoft.i18demo.infrastructure.db.repository.CatalogJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class CatalogRepositoryImpl implements CatalogRepository {

    private final CatalogDbMapper mapper;
    private final CatalogJpaRepository productJpaRepository;


    @Override
    public List<Catalog> getcatalogFromDatabaseByTypes(String type) {
        List<CatalogSQL> catalogSQLS = productJpaRepository.findCatalogsByType( type );
        List<Catalog> catalogs = catalogSQLS.stream().map( mapper::fromDbToDomain ).toList();
        return catalogs;
    }
}
