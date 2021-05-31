package eu.senla.statkevich.scooters.controller.securityConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@ComponentScan(basePackages = {"eu.senla.statkevich.scooters.service"})
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true,jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;


    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    //----------------аутентификация
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider());
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

    //----------------авторизация
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()//отключено для браузера
//                .addFilter(new JwtUsernameAndPasswordFilter(authenticationManager(), jwtConfig, secretKey))
//                .addFilterAfter(new JwtTokenVerifier(secretKey, jwtConfig), JwtUsernameAndPasswordFilter.class)
                .authorizeRequests()
                //.antMatchers("/roleSave").hasAnyRole( "ADMIN")
                .mvcMatchers("/helloUser", "/user/registration", "/priceList").permitAll()
                .mvcMatchers("/user/**", "/role/**", "/scooters/**", "/price/**", "/rent/**").hasAnyRole("USER", "ADMIN")

                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .loginProcessingUrl("/user")

        ;
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider());
    }


//    @Bean(name = "restTokenAuthenticationFilter")
//    public RestTokenAuthenticationFilter restTokenAuthenticationFilter() {
//        RestTokenAuthenticationFilter restTokenAuthenticationFilter = new RestTokenAuthenticationFilter();
//        tokenAuthenticationManager.setUserDetailsService(userDetailsService);
//        restTokenAuthenticationFilter.setAuthenticationManager(tokenAuthenticationManager);
//        return restTokenAuthenticationFilter;
//    }
}
