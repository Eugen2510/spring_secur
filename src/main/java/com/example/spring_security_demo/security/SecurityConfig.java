package com.example.spring_security_demo.security;

import com.example.spring_security_demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

import java.text.spi.CollatorProvider;
import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final DataSource dataSource;
    private static final String BY_USERNAME_QUERY = "SELECT username, password, enabled FROM users WHERE username=?";
    private static final String BY_USERNAME_ROLE_QUERY = "SELECT username, role FROM users WHERE username=?";

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeRequests(auth -> auth
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/user/show/**")).permitAll()
                        .anyRequest().authenticated())
                .formLogin(withDefaults());
        return http.build();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource)
                .dataSource(dataSource)
                .usersByUsernameQuery(BY_USERNAME_QUERY)
                .authoritiesByUsernameQuery(BY_USERNAME_ROLE_QUERY)
                .passwordEncoder(new BCryptPasswordEncoder());

//                .withDefaultSchema()
//                .withUser(User.withUsername("user")
//                        .password("jdbcDefault")
//                        .passwordEncoder((pas) -> new BCryptPasswordEncoder().encode(pas))
//                        .roles("USER"))
//                .withUser(User.withUsername("admin")
//                        .password("pass")
//                        .passwordEncoder((pas) -> new BCryptPasswordEncoder().encode(pas))
//                        .roles("ADMIN"))
//                .passwordEncoder(new BCryptPasswordEncoder());
    }

    /*
    private static final String BY_USERNAME_QUERY = "SELECT `username`, `password`, `enable` FROM `users` WHERE `username`=?";
    private static final String BY_USERNAME_ROLE_QUERY = "SELECT `username`, `role` FROM `users` WHERE `username`=?";

    @Autowired
    public void configAuthentication(final AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(BY_USERNAME_QUERY)
                .authoritiesByUsernameQuery(BY_USERNAME_ROLE_QUERY)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
     */

}

/*
Example Configurations
The most basic example is to configure all URLs to require the role "ROLE_USER". The configuration below requires authentication to every URL and will grant access to both the user "admin" and "user".
  @Configuration
  @EnableWebSecurity
  public class AuthorizeUrlsSecurityConfig {

  	@Bean
  	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
  		http
  			.authorizeRequests((authorizeRequests) ->
  				authorizeRequests
  					.requestMatchers("/**").hasRole("USER")
  			)
  			.formLogin(withDefaults());
  		return http.build();
  	}

  	@Bean
  	public UserDetailsService userDetailsService() {
  		UserDetails user = User.withDefaultPasswordEncoder()
  			.username("user")
  			.password("password")
  			.roles("USER")
  			.build();
  		UserDetails admin = User.withDefaultPasswordEncoder()
  			.username("admin")
  			.password("password")
  			.roles("ADMIN", "USER")
  			.build();
  		return new InMemoryUserDetailsManager(user, admin);
  	}
  }

We can also configure multiple URLs. The configuration below requires authentication to every URL and will grant access to URLs starting with /admin/ to only the "admin" user. All other URLs either user can access.
  @Configuration
  @EnableWebSecurity
  public class AuthorizeUrlsSecurityConfig {

  	@Bean
  	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
  		http
  			.authorizeRequests((authorizeRequests) ->
  				authorizeRequests
  					.requestMatchers("/admin/**").hasRole("ADMIN")
  					.requestMatchers("/**").hasRole("USER")
  			)
  			.formLogin(withDefaults());
  		return http.build();
  	}

  	@Bean
  	public UserDetailsService userDetailsService() {
  		UserDetails user = User.withDefaultPasswordEncoder()
  			.username("user")
  			.password("password")
  			.roles("USER")
  			.build();
  		UserDetails admin = User.withDefaultPasswordEncoder()
  			.username("admin")
  			.password("password")
  			.roles("ADMIN", "USER")
  			.build();
  		return new InMemoryUserDetailsManager(user, admin);
  	}
  }

Note that the matchers are considered in order. Therefore, the following is invalid because the first matcher matches every request and will never get to the second mapping:
  @Configuration
  @EnableWebSecurity
  public class AuthorizeUrlsSecurityConfig {

  	@Bean
  	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
  		 http
  		 	.authorizeRequests((authorizeRequests) ->
  		 		authorizeRequests
  			 		.requestMatchers("/**").hasRole("USER")
  			 		.requestMatchers("/admin/**").hasRole("ADMIN")
  		 	);
  		return http.build();
  	}
  }

 */
