package com.mashosoft.i18demo.config.dbprefill;

import com.mashosoft.i18demo.infrastructure.db.entity.CatalogIdSQL;
import com.mashosoft.i18demo.infrastructure.db.entity.CatalogSQL;
import com.mashosoft.i18demo.infrastructure.db.entity.ProductSQL;
import com.mashosoft.i18demo.infrastructure.db.repository.CatalogJpaRepository;
import com.mashosoft.i18demo.infrastructure.db.repository.ProductJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class FillDatabase implements CommandLineRunner {

    private final CatalogJpaRepository catalogJpaRepository;
    private final ProductJpaRepository productJpaRepository;

    @Override
    public void run(String... args) {
        CatalogSQL productTypeMop = new CatalogSQL(new CatalogIdSQL("M","PRODUCT_TYPE"),"Mop","Fregona","Mopp" );
        CatalogSQL productTypeBroom = new CatalogSQL(new CatalogIdSQL("B","PRODUCT_TYPE"),"Broom","Escoba","Besen" );
        CatalogSQL qualityGood = new CatalogSQL(new CatalogIdSQL("A","QUALITY"),"Good quality","Buena calidad","Gute Qualität" );
        CatalogSQL qualityBad = new CatalogSQL(new CatalogIdSQL("B","QUALITY"),"Normal quality","Calidad standard","Normale Qualität" );
        catalogJpaRepository.save( productTypeMop );
        catalogJpaRepository.save( productTypeBroom );
        catalogJpaRepository.save( qualityGood );
        catalogJpaRepository.save( qualityBad );

        ProductSQL mopHousify = new ProductSQL("abc123","M","Housify",10.5,"A" );
        ProductSQL mopMyHouse = new ProductSQL("abc1234","M","My House",14.10 ,"A");
        ProductSQL broom = new ProductSQL("dfg456","B","Housify",15.25 ,"B");
        productJpaRepository.save( mopHousify );
        productJpaRepository.save( mopMyHouse );
        productJpaRepository.save( broom );

    }
}
