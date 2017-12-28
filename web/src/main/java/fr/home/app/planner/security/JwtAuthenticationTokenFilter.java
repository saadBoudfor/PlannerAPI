package fr.home.app.planner.security;

import fr.home.app.planner.model.JwtAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {

    public JwtAuthenticationTokenFilter() {
        super("/api/**");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws
            IOException, ServletException {

        String header = httpServletRequest.getHeader("Authorisation");


        if (header == null || !header.startsWith("Token ")) {
            throw new TokenException("JWT Token is missing");
        }

        String authenticationToken = header.substring(6);

        JwtAuthenticationToken token = new JwtAuthenticationToken(authenticationToken);
        return getAuthenticationManager().authenticate(token);
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }
}
