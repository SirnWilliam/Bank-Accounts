package example.corelation.account.security;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import com.fasterxml.jackson.databind.ObjectMapper;

import example.corelation.account.database.AccountCredentials;
import example.corelation.account.service.AuthenticationService;



public class LoginFilter extends AbstractAuthenticationProcessingFilter {

	public LoginFilter(String url, AuthenticationManager authenticationManager) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authenticationManager);
	}
	
	@Override
	public Authentication attemptAuthentication ( HttpServletRequest request, HttpServletResponse response) 
			throws AuthenticationException ,IOException, ServletException {
			
		AccountCredentials credentials = new ObjectMapper()
				.readValue(request.getInputStream(), AccountCredentials.class);
		
		return getAuthenticationManager()
				.authenticate(new UsernamePasswordAuthenticationToken(
						credentials.getUsername(), credentials.getPassword(),Collections.emptyList()));
	}
	@Override
	protected void successfulAuthentication( HttpServletRequest request,
	HttpServletResponse response, FilterChain chain, Authentication auth) throws IOException, ServletException {

		AuthenticationService.addToken(response, auth.getName());
	}
}
