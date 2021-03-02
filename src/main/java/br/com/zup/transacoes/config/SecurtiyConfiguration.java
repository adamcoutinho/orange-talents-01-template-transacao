package br.com.zup.transacoes.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;

@Configuration
@EnableWebSecurity
public class SecurtiyConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/consultar/{identificador-cartao}").hasAnyAuthority("SCOPE_transacao-scope")
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .cors().disable()
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);

    }
}
