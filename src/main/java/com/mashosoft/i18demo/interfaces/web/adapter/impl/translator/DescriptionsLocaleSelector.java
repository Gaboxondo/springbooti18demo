package com.mashosoft.i18demo.interfaces.web.adapter.impl.translator;

import com.mashosoft.i18demo.domain.entity.Catalog;
import org.springframework.context.i18n.LocaleContextHolder;

public class DescriptionsLocaleSelector {

    public static String select(Catalog catalog){
        String country = LocaleContextHolder.getLocale().getLanguage();
        return switch(country) {
            case "en" -> catalog.getDescription_en();
            case "es" -> catalog.getDescription_es();
            case "de" -> catalog.getDescription_de();
            default -> catalog.getDescription_en();
        };
    }
}
