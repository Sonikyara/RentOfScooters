package eu.senla.statkevich.scooters.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@ComponentScan(basePackages = {"eu.senla.statkevich.scooters.service"})
@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

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
                .authorizeRequests()
                    .antMatchers("/user/**","/userByName/**").hasAnyRole("USER", "ADMIN")
                     .antMatchers("/helloUser","/saveUser").permitAll()

                 .and().formLogin()
         .loginProcessingUrl("/user")

        //                .anyRequest()  //каждый запрос-
//                .authenticated() //должен быть аутентифицирован
        //.loginPage("/login").permitAll()
        //.and().httpBasic();//как именно передается пароль и пользователь, в заголовке или в теле
        // .and().logout().logoutSuccessUrl("/login").permitAll();
        // .and().exceptionHandling().accessDeniedPage("/Access_Denied")
        ;
    }

//назначим разрешенных пользователей, пока один
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("Ira").password(encoder().encode("56kle5")).roles("user");
        auth.authenticationProvider(authProvider());
    }
//------------
}
