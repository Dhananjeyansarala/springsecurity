package onesoftsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.web.servlet.AuthorizeRequestsDsl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity 
@Configuration
public class OnesoftConfiguration extends WebSecurityConfigurerAdapter{
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("dhana").password("$2a$12$1UAknWFPNI7eFbyR4xC.ouQ4qg.hkOTWD8LqpaNTsqeV.u/In6n6."
//				+ "").roles("student");
//		
//		
//	}
////	@Bean
////	public PasswordEncoder getpass() {
////		return NoOpPasswordEncoder.getInstance();
////	}
//	@Bean
//	public PasswordEncoder getpassword() {
//		return new BCryptPasswordEncoder(10);
//	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("dhana").password("$2a$12$UkSLEFhz27GBrX2GOURs6eaW6maoFMwrlx2ikMz67XV.rh/CsINGi").
		roles("student").and().withUser("arun").password("$2a$12$P42fYNd68WJsMLrIm2FzmOEhEuLpbrEc2uW3ac/oCp9QfKjKg3J26").
		roles("trainer").and().withUser("karthi").password("$2a$12$8druo6NEoZh9Gk7qdxkFWuB7vwSaBmIuhNT1yMCA.LJxgixCm6IW.").
		roles("manager");
	}
	@Bean
	public PasswordEncoder getpass() {
		return new BCryptPasswordEncoder(12);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/manager").hasRole("manager");
		//http.authorizeRequests().antMatchers("/trainer").hasAnyRole("trainer", "manager");
		http.authorizeRequests().antMatchers("/trainer").permitAll().and().formLogin();
		http.authorizeRequests().antMatchers("/student").hasAnyRole("manager","trainer","student");

	}
	

}
