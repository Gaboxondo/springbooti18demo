package com.mashosoft.i18demo.interfaces.web.adapter.translator;

import com.mashosoft.i18demo.application.CatalogService;
import com.mashosoft.i18demo.application.impl.CatalogServiceimpl;
import com.mashosoft.i18demo.domain.entity.Catalog;
import com.mashosoft.i18demo.interfaces.web.dto.ProductDTO;
import lombok.AllArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Component
public class DtoLiteralsFiller {

    private final CatalogService catalogService;

    public void addDescriptions(List<ProductDTO> productDTOS){
        //This should be an enum
        List<Catalog> catalogList = catalogService.getcatalogsByTypes( "productType" );
        productDTOS.forEach( productDTO -> {
            Catalog productCodeCatalog = Catalog.filterListByCode( catalogList,productDTO.getType().getCode() );
            //Here it should go exception and so on but I will ommit that. I am doing this fast to show you quick
            productDTO.getType().setDescription( selectDescriptionAccordingToLang( productCodeCatalog ) );
        } );
    }
    public void addDescriptions(ProductDTO productDTO){
        //This should be an enum
        List<Catalog> catalogList = catalogService.getcatalogsByTypes( "productType" );
        Catalog productCodeCatalog = Catalog.filterListByCode( catalogList,productDTO.getType().getCode() );
        //Here it should go exception and so on but I will ommit that. I am doing this fast to show you quick
        productDTO.getType().setDescription( selectDescriptionAccordingToLang( productCodeCatalog ) );
    }

    private String selectDescriptionAccordingToLang(Catalog catalog){
        String country = LocaleContextHolder.getLocale().getLanguage();
        return switch(country) {
            case "en" -> catalog.getDescription_en();
            case "es" -> catalog.getDescription_es();
            case "de" -> catalog.getDescription_de();
            default -> catalog.getDescription_en();
        };
    }
}
