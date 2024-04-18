package com.mashosoft.i18demo.config.i18;

//All of this is better to have it in a lib, we already have it
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class I18Config implements WebMvcConfigurer {

    @Order(Ordered.HIGHEST_PRECEDENCE)
    @Bean(name = DispatcherServlet.LOCALE_RESOLVER_BEAN_NAME)
    public LocaleResolver localResolver(){
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale( new Locale( "de","de" ) );
        return slr;
    }
}
