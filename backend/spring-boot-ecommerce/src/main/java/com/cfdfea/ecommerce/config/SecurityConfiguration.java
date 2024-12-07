package com.cfdfea.ecommerce.config;

import com.nimbusds.jwt.SignedJWT;
import com.okta.spring.boot.oauth.Okta;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.oauth2.jwt.JwtTimestampValidator;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.cors.CorsConfigurationSource;

import java.text.ParseException;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

////    @Bean
////    public JwtDecoder jwtDecoder() {
////        String jwkSetUri = "https://dev-17162308.okta.com/oauth2/default/v1/keys";
////        NimbusJwtDecoder jwtDecoder = NimbusJwtDecoder.withJwkSetUri(jwkSetUri).build();
////
////        // Add a custom claim type converter if needed or modify parsing rules here
////        jwtDecoder.setClaimSetConverter(claims -> {
////            // Custom logic to handle Okta claims, if necessary
////            return claims;
////        });
////
////        return jwtDecoder;
////    }
//
//    @Bean
//    public JwtDecoder customJwtDecoder() {
//        String jwkSetUri = "https://dev-17162308.okta.com/oauth2/default/v1/keys"; // Replace with your Okta JWKS URI
//
//
//        NimbusJwtDecoder jwtDecoder = NimbusJwtDecoder.withJwkSetUri(jwkSetUri)
//                .jwsAlgorithm(SignatureAlgorithm.RS256)
//                .build();
//
//
//
//        return jwtDecoder;
//    }

    private final CorsConfigurationSource corsConfigurationSource;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // protect endpoint /api/orders
        http.authorizeRequests(configurer ->
                        configurer
                                .antMatchers("/api/orders/**")
                                .authenticated())
                .oauth2ResourceServer()
                .jwt();

        // add CORS filters
        http.cors();

        // add content negotiation strategy
        http.setSharedObject(ContentNegotiationStrategy.class,
                             new HeaderContentNegotiationStrategy());

        // force a non-empty response body for 401's to make the response more friendly
        Okta.configureResourceServer401ResponseBody(http);

        // disable CSRF since we are not using Cookies for session tracking
        http.csrf().disable();

        return http.build();
    }
}







