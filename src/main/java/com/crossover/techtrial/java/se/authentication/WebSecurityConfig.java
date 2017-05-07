package com.crossover.techtrial.java.se.authentication;

import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.fasterxml.jackson.databind.ObjectMapper;

@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@Configuration
@EnableWebSecurity
@ComponentScan("mainEntry.authentication")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	////
	 public static final String JWT_TOKEN_HEADER_PARAM = "X-Authorization";
	    public static final String FORM_BASED_LOGIN_ENTRY_POINT = "/auth/login";
	    public static final String TOKEN_BASED_AUTH_ENTRY_POINT = "/**";
	    public static final String TOKEN_REFRESH_ENTRY_POINT = "/auth/token";

	    @Autowired private RestAuthenticationEntryPoint authenticationEntryPoint;
	    @Autowired private AuthenticationSuccessHandler successHandler;
	    @Autowired private AuthenticationFailureHandler failureHandler;
	    @Autowired private JwtAuthenticationProvider jwtAuthenticationProvider;

	    @Autowired private JwtHeaderTokenExtractor tokenExtractor;

	    @Autowired private AuthenticationManager authenticationManager;

	    @Autowired private ObjectMapper objectMapper;
	
	    protected JwtTokenAuthenticationProcessingFilter buildJwtTokenAuthenticationProcessingFilter() throws Exception {
	        List<String> pathsToSkip = Arrays.asList(TOKEN_REFRESH_ENTRY_POINT, FORM_BASED_LOGIN_ENTRY_POINT);
	        SkipPathRequestMatcher matcher = new SkipPathRequestMatcher(pathsToSkip, TOKEN_BASED_AUTH_ENTRY_POINT);
	        JwtTokenAuthenticationProcessingFilter filter 
	            = new JwtTokenAuthenticationProcessingFilter(failureHandler, tokenExtractor, matcher);
	        filter.setAuthenticationManager(this.authenticationManager);
	        return filter;
	    }

	    @Bean
	    @Override
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) {
	        auth.authenticationProvider(jwtAuthenticationProvider);
	    }

	    @Bean
	    protected BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	        .csrf().disable() // We don't need CSRF for JWT based authentication
	        .exceptionHandling()
	        .authenticationEntryPoint(this.authenticationEntryPoint)

	        .and()
	            .sessionManagement()
	            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

	        .and()
	            .authorizeRequests()
	                .antMatchers(FORM_BASED_LOGIN_ENTRY_POINT).permitAll() // Login end-point
	                .antMatchers(TOKEN_REFRESH_ENTRY_POINT).permitAll() // Token refresh end-point
	                .antMatchers("/console").permitAll() // H2 Console Dash-board - only for testing
	        .and()
	            .authorizeRequests()
	                .antMatchers(TOKEN_BASED_AUTH_ENTRY_POINT).authenticated() // Protected API End-points
	        .and()
	            .addFilterBefore(buildAjaxLoginProcessingFilter(), UsernamePasswordAuthenticationFilter.class)
	            .addFilterBefore(buildJwtTokenAuthenticationProcessingFilter(), UsernamePasswordAuthenticationFilter.class);
	    }
	////
	
	
	@Autowired
	DataSource dataSource;

//	@Autowired
//	private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
//
//	@Autowired
//	private MySavedRequestAwareAuthenticationSuccessHandler authenticationSuccessHandler;
//
//	@Autowired
//	public void configAuthentication(AuthenticationManagerBuilder auth)
//			throws Exception {
//
//		auth.jdbcAuthentication()
//				.dataSource(dataSource)
//				.usersByUsernameQuery(
//						"select email ,password, true from user where email=?")
//				.authoritiesByUsernameQuery(
//						"select user.email , role.name from user , role where email=? and role.id = user.role_id");
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http.httpBasic()
//				.and()
//				.authorizeRequests()
//				.antMatchers("/userSignup")
//				.permitAll()
//				.antMatchers("/logout", "/getUserRole")
//				.authenticated()
//				.antMatchers(HttpMethod.GET, "/getAllUsersForAdmin",
//						"/getAllOrdersForAdmin")
//				.hasRole("ADMIN_ROLE")
//				.antMatchers(HttpMethod.GET, "/getAllPurchasedTickets",
//						"/getAllOffers").hasRole("USER_ROLE")
//				.antMatchers(HttpMethod.POST, "/buyTicket")
//				.hasRole("USER_ROLE").and().formLogin()
//				.successHandler(authenticationSuccessHandler)
//				.failureHandler(new SimpleUrlAuthenticationFailureHandler())
//				.and().logout().and().csrf().disable();
//
//	}
//
//	@Bean
//	public MySavedRequestAwareAuthenticationSuccessHandler mySuccessHandler() {
//		return new MySavedRequestAwareAuthenticationSuccessHandler();
//	}
//
//	@Bean
//	public SimpleUrlAuthenticationFailureHandler myFailureHandler() {
//		return new SimpleUrlAuthenticationFailureHandler();
//	}

}