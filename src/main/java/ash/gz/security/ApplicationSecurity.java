package ash.gz.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.servlet.http.HttpServletResponse;

@Configuration
public class ApplicationSecurity extends WebSecurityConfigurerAdapter
{
  @Value("${spring.security.user.name}")
  private String username;

  @Value("${spring.security.user.password}")
  private String password;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception
  {
    auth.inMemoryAuthentication()
        .withUser(username)
        .password("{noop}" + password)
        .roles("USER");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception
  {
    http.authorizeRequests()
        .anyRequest()
        .authenticated()
        .and()
        .httpBasic();

    http.exceptionHandling()
        .authenticationEntryPoint(
            (httpServletRequest, httpServletResponse, e) -> httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED));
  }
}
