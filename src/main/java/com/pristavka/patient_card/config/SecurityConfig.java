package com.pristavka.patient_card.config;

import com.pristavka.patient_card.model.UserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
                .authorizeRequests()
                .antMatchers("/swagger-ui-patient-card.html").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }


    @Override
    protected UserDetailsService userDetailsService()
    {
        return new InMemoryUserDetailsManager(

                User.builder()
                        .username("tim")
                        .password(passwordEncoder().encode("12345"))
                        .roles(UserRole.Admin.toString())
                        .build(),

                User.builder()
                        .username("ivanova")
                        .password(passwordEncoder().encode("11111"))
                        .roles(UserRole.User.toString())
                        .build()

        );
    }

    @Bean
    PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}

