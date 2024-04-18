package com.mashosoft.i18demo.config.i18;

//All of this is better to have it in a lib, we already have it
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class Translator {

    @Autowired
    @Qualifier("CustomMessageSource")
    private MessageSource messageSource;

    private final String ERROR_TRANSLATING = "Error translating";

    public String translateCode(String msgCode, @Nullable Object[] parameters){
        Locale locale = LocaleContextHolder.getLocale();

        String message;
        try{
            message = messageSource.getMessage( msgCode, parameters, locale );
        } catch(Exception e){
            message = ERROR_TRANSLATING;
        }

        return message;
    }
}
