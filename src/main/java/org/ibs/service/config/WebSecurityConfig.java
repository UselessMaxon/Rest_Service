package org.ibs.service.config;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

/**Starting from Spring Security version 5.7.0-M2 the WebSecurityConfigurerAdapter is deprecated
 *
 */
/*
@KeycloakConfiguration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public abstract class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new NullAuthenticatedSessionStrategy();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authManagerBuilder) {
        KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
        authManagerBuilder.authenticationProvider(keycloakAuthenticationProvider);
    }

    @Bean
    public KeycloakConfigResolver keycloakConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String indexUl = "/swagger-ui/index.html?configUrl=/api/v3/api-docs/swagger-config";

        super.configure(http);
        http
                .csrf().disable()
                .authorizeRequests()
                .requestMatchers("/**").hasRole("READER")
                .requestMatchers(HttpMethod.DELETE, "/v2/employees").hasRole("WRITER")
                .requestMatchers(HttpMethod.POST, "/v2/employees").hasRole("WRITER")
                .and()
                .formLogin()
                .defaultSuccessUrl(indexUl, true);
    }
}
*/