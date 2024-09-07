package com.hardeymorlah.RewardsManagementAPI.config;

import com.hardeymorlah.RewardsManagementAPI.model.Enum.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private RewardsManagementAPIFilter rewardsManagementAPIFilter;

    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Autowired
    private RewardsManagementAPIFilter rewardsAppFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/v1/customers/register", "/api/v1/customers/login").permitAll()
                        .requestMatchers("/api/v1/customers/**").hasAuthority(Role.USER.name())
                        .requestMatchers("/api/v1/transactions/**").hasAuthority(Role.USER.name())
                        .requestMatchers("/api/v1/transactions/post_transaction").hasAuthority(Role.USER.name())
                        .requestMatchers("/api/v1/rewards/**").hasAuthority(Role.USER.name())
                        .anyRequest().authenticated())
                .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(rewardsAppFilter, UsernamePasswordAuthenticationFilter.class)
                .httpBasic(Customizer.withDefaults());

                 return httpSecurity.build();

    }

}