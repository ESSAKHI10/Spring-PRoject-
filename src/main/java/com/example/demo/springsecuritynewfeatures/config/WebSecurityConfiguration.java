package com.example.demo.springsecuritynewfeatures.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfiguration {
    @Autowired
    private JwtAthFilter jwtAthFilter;
    // @Autowired
    // private UserDao userDao;
    @Autowired
    private AccountAuthenticationProvider accountAuthenticationProvider;

    // http requests going throuth here before controller
    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // AuthenticationManagerBuilder
        // authenticationManagerBuilder=http.getSharedObject(AuthenticationManagerBuilder.class);
        // authenticationManagerBuilder.authenticationProvider(accountAuthenticationProvider);
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/**/auth/**", "/**/employees/**", "/**/accounts/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(accountAuthenticationProvider)// usew our auth prov

                .addFilterBefore(jwtAthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();

    }

    // @Bean
    // protected AuthenticationProvider authenticationProvider() {
    // final DaoAuthenticationProvider authenticationProvider = new
    // DaoAuthenticationProvider();
    // authenticationProvider.setUserDetailsService(userDetailsService());
    // authenticationProvider.setPasswordEncoder(passwordEncoder());
    // return authenticationProvider;

    // }

    // @Bean
    // protected UserDetailsService userDetailsService() {
    // //
    // // return email -> userDao.findUserByEmail(email);

    // //
    // return new UserDetailsService() {
    // @Override
    // public UserDetails loadUserByUsername(String email) throws
    // UsernameNotFoundException {
    // return userDao.findUserByEmail(email);
    // }
    // };
    // }

}
