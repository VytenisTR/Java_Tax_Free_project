package project.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import project.HttpEndpoint;
import project.security.service.CustomUserDetailsService;
import java.util.Locale;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class BasicSecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/submit/**").hasRole("ADMIN")
                        .requestMatchers("/details/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpEndpoint.LOGIN, HttpEndpoint.LOGOUT,
                                "/css/**", "/js/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .loginPage(HttpEndpoint.LOGIN)
                        .loginProcessingUrl(HttpEndpoint.LOGIN)
                        .defaultSuccessUrl("/", true)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl(HttpEndpoint.LOGOUT)
                        .addLogoutHandler((request, response,
                                           authentication) -> {
                            Locale locale = (Locale) request.getSession()
                                    .getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
                            if (locale != null) {
                                request.setAttribute("lang", locale.getLanguage());
                            }
                        })
                        .logoutSuccessHandler((request, response,
                                               authentication) -> {
                            String sessionLanguage = (String) request.getAttribute("lang");
                            response.sendRedirect("/login?logout&lang=" + sessionLanguage);
                        })
                )
                .exceptionHandling(exception -> exception
                        .accessDeniedPage(HttpEndpoint.ACCESS_DENIED)
                );

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationBuilder.authenticationProvider(daoAuthenticationProvider());

        return authenticationBuilder.build();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(customUserDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

        return daoAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}