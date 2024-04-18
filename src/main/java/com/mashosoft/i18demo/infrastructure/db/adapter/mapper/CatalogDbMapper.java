package com.mashosoft.i18demo.infrastructure.db.adapter.mapper;

import com.mashosoft.i18demo.domain.entity.Catalog;
import com.mashosoft.i18demo.domain.entity.Product;
import com.mashosoft.i18demo.infrastructure.db.entity.CatalogSQL;
import com.mashosoft.i18demo.infrastructure.db.entity.ProductSQL;
import org.springframework.stereotype.Component;

@Component
public class CatalogDbMapper {

    public Catalog fromDbToDomain(CatalogSQL catalogSQL){
        if(catalogSQL == null){
            return null;
        }
        return new Catalog(catalogSQL.getId().getCode(), catalogSQL.getId().getType(), catalogSQL.getDescription_en(), catalogSQL.getDescription_es(),catalogSQL.getDescription_de());
    }
}
