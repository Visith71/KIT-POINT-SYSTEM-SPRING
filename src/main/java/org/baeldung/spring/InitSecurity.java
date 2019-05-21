package org.baeldung.spring;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class InitSecurity extends AbstractSecurityWebApplicationInitializer {

    public InitSecurity() {
        super(SecSecurityConfig.class);
    }
}
