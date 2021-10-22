package com.elfak.whreceiver.security

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import kotlin.Throws
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import com.elfak.whreceiver.security.APIKeyAuthFilter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.config.http.SessionCreationPolicy
import java.lang.Exception

@Configuration
@EnableWebSecurity
@Order
class APISecurityConfig : WebSecurityConfigurerAdapter() {

    @Value("\${whserver.http.auth-token-header-name}")
    private val principalRequestHeader: String? = null

    @Value("\${whserver.http.auth-token}")
    private val principalRequestValue: String? = null

    @Throws(Exception::class)
    override fun configure(httpSecurity: HttpSecurity) {

        val filter = APIKeyAuthFilter(principalRequestHeader!!)

        filter.setAuthenticationManager { authentication ->
            val principal = authentication.principal as String
            if (principalRequestValue != principal) {
                throw BadCredentialsException("The API key was not found or not the expected value.")
            }
            authentication.isAuthenticated = true
            authentication
        }

        httpSecurity.antMatcher("/api/**").csrf().disable().sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().addFilter(filter)
            .authorizeRequests().anyRequest().authenticated()
    }
}