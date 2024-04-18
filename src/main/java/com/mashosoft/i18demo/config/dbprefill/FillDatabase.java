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
    public void run(String... args) throws Exception {
        CatalogSQL productTypeMop = new CatalogSQL(new CatalogIdSQL("M","productType"),"Mop","Fregona","Mopp" );
        CatalogSQL productTypeBroom = new CatalogSQL(new CatalogIdSQL("B","productType"),"Broom","Escoba","Besen" );
        catalogJpaRepository.save( productTypeMop );
        catalogJpaRepository.save( productTypeBroom );

        ProductSQL mopHousify = new ProductSQL("abc123","M","Housify",10.5 );
        ProductSQL mopMyHouse = new ProductSQL("abc1234","M","My House",14.10 );
        ProductSQL broom = new ProductSQL("dfg456","B","Housify",15.25 );
        productJpaRepository.save( mopHousify );
        productJpaRepository.save( mopMyHouse );
        productJpaRepository.save( broom );

    }
}
