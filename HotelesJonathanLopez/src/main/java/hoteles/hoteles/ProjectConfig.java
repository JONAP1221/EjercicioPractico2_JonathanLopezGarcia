/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hoteles.hoteles;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
/**
 *
 * @author gabriel badilla
 */
public class ProjectConfig implements WebMvcConfigurer{
    /*
    Un @Bean son notaciones de spring que funcionan para definir metodos y seran 
    gestionados por el contenedor de Spring 
    
    @Bean
    public LocaleResolver localeResolver () {
    El localeResolver se utiliza para sesion de usuario y configuracion regional
    */
     @Bean
    public SessionLocaleResolver localeResolver() {
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.getDefault());
        slr.setLocaleAttributeName("session.current.locale");
        slr.setTimeZoneAttributeName("session.current.timezone");
        return slr;
        }
    
    @Bean
    public LocaleChangeInterceptor localeChanceInterceptor(){
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
    /*
       Este funciona para cambiar el locale en funcion de una solicitud osea modifica el de arriba
    */
    /*
    Este no lo entendi 
    */
    @Override
    public void addInterceptors(InterceptorRegistry registro){
        registro.addInterceptor(localeChanceInterceptor());
    }
    /*
        Este lee archivps y establece nombres base de los archivos de mensajes 
    */
    @Bean("messageBrouce")
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("message");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
    
}