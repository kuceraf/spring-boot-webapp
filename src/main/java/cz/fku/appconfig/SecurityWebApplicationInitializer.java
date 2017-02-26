package cz.fku.appconfig;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by Filip on 26.02.2017.
 */
public class SecurityWebApplicationInitializer
        extends AbstractSecurityWebApplicationInitializer {

    public SecurityWebApplicationInitializer() {
        super(WebSecurityConfig.class);
    }
}