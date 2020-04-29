package counter.config;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors().and().authorizeRequests().antMatchers("/v2/counter/flights**").permitAll().anyRequest().hasRole("Counter")
        .and().oauth2ResourceServer().jwt().jwtAuthenticationConverter(new JwtAuthenticationConverter() {
          @Override
          protected Collection<GrantedAuthority> extractAuthorities(final Jwt jwt) {
            Collection<GrantedAuthority> authorities = super.extractAuthorities(jwt);
            List<String> roles = jwt.getClaimAsStringList("cognito:groups");
            authorities.addAll(
                roles.stream().map(x -> new SimpleGrantedAuthority("ROLE_" + x)).collect(Collectors.toSet()));
            return authorities;
          }
        });
    // .oauth2Login()
    // .and()
    // .csrf()
    // .disable();
  }
}