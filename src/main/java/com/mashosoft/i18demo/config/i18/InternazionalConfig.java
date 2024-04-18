package com.mashosoft.i18demo.config.i18;

//All of this is better to have it in a lib, we already have it
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class InternazionalConfig implements WebMvcConfigurer {

    @Bean(name = "CustomMessageSource")
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename( "LocaleMessage" );
        messageSource.setDefaultEncoding( "UTF-8" );
        return messageSource;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName( "lang" );
        localeChangeInterceptor.setIgnoreInvalidLocale( true );
        return localeChangeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry){
        interceptorRegistry.addInterceptor( localeChangeInterceptor() );
    }
}
