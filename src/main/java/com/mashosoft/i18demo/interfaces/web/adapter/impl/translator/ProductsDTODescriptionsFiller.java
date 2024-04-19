package com.mashosoft.i18demo.interfaces.web.adapter.impl.translator;

import com.mashosoft.i18demo.application.CatalogService;
import com.mashosoft.i18demo.domain.entity.Catalog;
import com.mashosoft.i18demo.interfaces.web.dto.ProductDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class ProductsDTODescriptionsFiller {

    private final CatalogService catalogService;

    public void addDescriptions(List<ProductDTO> productDTOS){
        //This should be an enum
        List<Catalog> catalogList = catalogService.getAll( );
        productDTOS.forEach( productDTO -> {
            fillProductDescription(productDTO,catalogList);
        } );
    }
    public void addDescriptions(ProductDTO productDTO){
        //This should be an enum
        List<Catalog> catalogList = catalogService.getAll( );
        fillProductDescription(productDTO,catalogList);
    }

    //------------------------------------------------------------

    private void fillProductDescription(ProductDTO productDTO, List<Catalog> catalogs){
        Catalog productTypeCodecatalog = Catalog.filterListByTypeAndCode( catalogs,"PRODUCT_TYPE",productDTO.getType().getCode() );
        Catalog productQualityCodecatalog = Catalog.filterListByTypeAndCode( catalogs,"QUALITY",productDTO.getQuality().getCode() );
        //Here it should go exception and so on but I will ommit that. I am doing this fast to show you quick
        productDTO.getType().setDescription( DescriptionsLocaleSelector.select( productTypeCodecatalog ) );
        productDTO.getQuality().setDescription( DescriptionsLocaleSelector.select( productQualityCodecatalog ) );
    }
}
