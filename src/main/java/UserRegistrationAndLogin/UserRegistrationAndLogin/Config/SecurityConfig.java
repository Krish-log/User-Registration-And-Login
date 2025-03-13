package UserRegistrationAndLogin.UserRegistrationAndLogin.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // Disable CSRF for testing
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/users/**").permitAll() // Allow access to user APIs
                .anyRequest().permitAll() // Allow all other requests
            )
            .formLogin(login -> login.disable()) // Disable default login page
            .httpBasic(basic -> basic.disable()); // Disable basic authentication

        return http.build();
    }
}

