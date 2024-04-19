package com.mashosoft.i18demo.config.i18;

//All of this is better to have it in a lib, we already have it
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class I18Config implements WebMvcConfigurer {

    @Order(Ordered.HIGHEST_PRECEDENCE)
    @Bean(name = DispatcherServlet.LOCALE_RESOLVER_BEAN_NAME)
    public LocaleResolver localResolver(){
        //There are a lot of types of resolvers, in this case is a session locale
        // https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-servlet/localeresolver.html
        //AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale( new Locale( "de","de" ) );
        return localeResolver;
    }
}
