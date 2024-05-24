package com.sergei.spring.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

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
    public InMemoryUserDetailsManager userDetailsService() {
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
}
