package org.eu.flam.bivi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import jakarta.servlet.DispatcherType;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChainProtected(HttpSecurity http) throws Exception {
		http
				.csrf((csrf) -> csrf.disable())
				.exceptionHandling(exception -> exception.accessDeniedPage("/login"))
				.authorizeHttpRequests(
						(auth) -> auth
								.dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.ERROR)
								.permitAll()
								.requestMatchers(
										new AntPathRequestMatcher(
												"/includes/**"))
								.permitAll()
								.requestMatchers(new AntPathRequestMatcher("/css/**")).permitAll()
								.requestMatchers(new AntPathRequestMatcher("/img/**")).permitAll()
								.requestMatchers(new AntPathRequestMatcher("/webjars/**")).permitAll()
								.requestMatchers(
										HttpMethod.GET,
										"/", "/login", "/users/*", "/books/**", "/search", "/search/**", "/help", "/about", "/privacy")
								.permitAll()
								.requestMatchers(
										HttpMethod.POST,
										"/users/new", "/search")
								.permitAll()
								.requestMatchers(
										HttpMethod.GET,
										"/books", "/books/**", "/quests/**", "/answers/**")
								.authenticated()
								.requestMatchers(
										HttpMethod.POST,
										"/books/new", "/quests/**", "/answers/**")
								.authenticated()
								.requestMatchers(
										HttpMethod.GET,
										"/genres", "/genres/*")
								.authenticated()
								.requestMatchers(
										HttpMethod.POST,
										"/genres/new")
								.authenticated()
								.requestMatchers(
										HttpMethod.POST,
										"/comments/new")
								.authenticated()
								.anyRequest()
								.authenticated())
				.formLogin((login -> login
						.usernameParameter("email")
						.loginPage("/login")
						.defaultSuccessUrl("/login?success", true)))
				.logout(logout -> logout
						.logoutUrl("/logout")
						.logoutSuccessUrl("/")
						.invalidateHttpSession(true)
						.clearAuthentication(true)
						.deleteCookies("JSESSIONID"))
				.sessionManagement(session -> session
						.maximumSessions(1)
						.expiredUrl("/"));

		return http.build();
	}
}