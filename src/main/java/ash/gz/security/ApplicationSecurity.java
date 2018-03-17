package ash.gz.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Collections;

@EnableWebSecurity
public class ApplicationSecurity extends WebSecurityConfigurerAdapter
{
  @Value("${user.username}")
  private String user_username;

  @Value("${user.password}")
  private String user_password;

  @Value("${admin.username}")
  private String admin_username;

  @Value("${admin.password}")
  private String admin_password;

  private final String USER_ROLE = "USER";

  private final String ADMIN_ROLE = "ADMIN";

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception
  {
    auth.inMemoryAuthentication()
        .withUser(user_username)
        .password("{noop}" + user_password)
        .roles(USER_ROLE)
        .and()
        .withUser(admin_username)
        .password("{noop}" + admin_password)
        .roles(ADMIN_ROLE, USER_ROLE);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception
  {
    http.cors().and()
        .csrf().disable()
        .authorizeRequests()
        .mvcMatchers(HttpMethod.GET, "/count").anonymous()
        .mvcMatchers(HttpMethod.GET, "/test").hasRole(USER_ROLE)
        .mvcMatchers(HttpMethod.POST, "/submissions").hasRole(USER_ROLE)
        .mvcMatchers(HttpMethod.GET, "/submissions/*").hasRole(USER_ROLE)
        .anyRequest().hasRole(ADMIN_ROLE)
        .and().httpBasic()
        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    http.exceptionHandling()
        .authenticationEntryPoint(
            (httpServletRequest, httpServletResponse, e) -> httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED));
  }

  @Bean
  CorsConfigurationSource corsConfigurationSource()
  {
    final CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(Collections.unmodifiableList(Arrays.asList("*")));
    configuration.setAllowedMethods(Collections.unmodifiableList(Arrays.asList("GET","POST")));
    configuration.setAllowedHeaders(Collections.unmodifiableList(Arrays.asList("*")));
    configuration.setAllowCredentials(true);
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }
}
