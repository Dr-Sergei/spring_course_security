package com.sergei.spring.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {

    //https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter

    //old way to do
//    @Configuration
//    public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//        @Override
//        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//            UserDetails user = User.withDefaultPasswordEncoder()
//                    .username("user")
//                    .password("password")
//                    .roles("USER")
//                    .build();
//            auth.inMemoryAuthentication()
//                    .withUser(user);
//        }
//    }


    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User.withDefaultPasswordEncoder()
                .username("sergei")
                .password("aaa")
                .roles("EMPLOYEE")
                .build();

        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("zaur")
                .password("bbb")
                .roles("HR")
                .build();

        UserDetails user3 = User.withDefaultPasswordEncoder()
                .username("elena")
                .password("ccc")
                .roles("MANAGER", "HR")
                .build();

        UserDetails[] users = {user1, user2, user3};

        return new InMemoryUserDetailsManager(users);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((aut) -> aut
                        .requestMatchers("/").hasAnyRole("EMPLOYEE", "HR", "MANAGER")
                        .requestMatchers("/hrInfo").hasRole("HR")
                        .requestMatchers("/managerInfo").hasRole("MANAGER")
                        .anyRequest().authenticated()
                )
                .formLogin(withDefaults());

        return http.build();

        //https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/index.html
    }


}
