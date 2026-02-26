package cat.institutmarianao.orders.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration
public class WebSecurityConfiguration {

	private static final String ADMIN_ROLE = "ADMIN";
	private static final String USER_ROLE = "USER";
	private static final String ADMIN_URL_PATH = "/admin/**";
	private static final String USERS_URL_PATH = "/users/**";
	private static final String LOGIN_URL = "/login";
	private static final String LOGIN_FAIL_URL = "/loginfailed";
	private static final String LOGOUT_URL = "/logout";
	private static final String DEFAULT_SUCCESS_URL = "/";

	private static final String[] ENDPOINTS_WHITELIST = { "/css/**", "/js/**", "/images/**", LOGIN_URL,
			LOGIN_FAIL_URL };

	@Bean
	PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) {
		http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(
				authorize -> authorize.dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.ERROR).permitAll()
		/* REVIEW - Intercept urls and define access according to requirements */
				.requestMatchers(ENDPOINTS_WHITELIST).permitAll()
				.requestMatchers(USERS_URL_PATH).hasAnyRole(USER_ROLE)
				.requestMatchers(ADMIN_URL_PATH).hasAnyRole(ADMIN_ROLE)
				.anyRequest().authenticated()
		)
		/* REVIEW - Configure form login according to requirements */
		.formLogin(form -> form
				.loginPage(LOGIN_URL)
				.failureUrl(LOGIN_FAIL_URL)
				.defaultSuccessUrl(DEFAULT_SUCCESS_URL)
				.permitAll())
		/* REVIEW - Configure logout according to requirements */
		.logout(logout -> logout
				.logoutUrl(LOGOUT_URL)
                .logoutSuccessUrl(DEFAULT_SUCCESS_URL)
                .deleteCookies("JSESSIONID")
				.invalidateHttpSession(true)
				.permitAll())
		/* REVIEW - Configure exception handling according to requirements */
		
		.exceptionHandling((exceptionHandling) ->
			exceptionHandling
				.accessDeniedPage(DEFAULT_SUCCESS_URL)
		);
		return http.build();
	}
}