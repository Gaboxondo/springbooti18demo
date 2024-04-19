package com.mashosoft.i18demo.application.impl;

import com.mashosoft.i18demo.application.CatalogService;
import com.mashosoft.i18demo.domain.entity.Catalog;
import com.mashosoft.i18demo.domain.repository.CatalogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CatalogServiceimpl implements CatalogService {

    private final CatalogRepository catalogRepository;

    public List<Catalog> getcatalogsByTypes(String type){
        return catalogRepository.getcatalogFromDatabaseByTypes( type );
    }

    public List<Catalog> getAll(){
        return catalogRepository.getAllFromDatabase(  );
    }
}
