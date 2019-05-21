package org.baeldung.spring;

import org.baeldung.security.ActiveUserStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletRegistration;

@Configuration
public class AppConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    public AppConfig(){
        super();
    }
    // beans

    @Bean
    public ActiveUserStore activeUserStore() {
        return new ActiveUserStore();
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {
                MvcConfig.class, SecSecurityConfig.class, InitSecurity.class, CaptchaConfig.class
                ,LoginNotificationConfig.class,PersistenceJPAConfig.class,ServiceConfig.class
                ,SetupDataLoader.class,SpringTaskConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
    @Override
    protected void customizeRegistration(final ServletRegistration.Dynamic registration) {
        super.customizeRegistration(registration);
    }
}