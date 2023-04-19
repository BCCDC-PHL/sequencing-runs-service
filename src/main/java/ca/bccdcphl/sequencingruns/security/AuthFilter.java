package ca.bccdcphl.sequencingruns.security;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class AuthFilter extends OncePerRequestFilter {

    private static final Logger log = LoggerFactory.getLogger(AuthFilter.class);
    // Only for use during early development.
    // TODO: Load this from the environment or config file.
    // TODO: Replace this simple token-based auth with real Oauth2/OIDC authentication
    private static final String READ_TOKEN = "secret";
    private static final String WRITE_TOKEN = "supersecret";

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        String providedToken = request.getHeader("Authorization");
        String requiredToken = null;
        if (request.getMethod().equals("GET")) {
            requiredToken = READ_TOKEN;
        } else if (request.getMethod().equals("POST")) {
            requiredToken = WRITE_TOKEN;
        } else if (request.getMethod().equals("PATCH")) {
            requiredToken = WRITE_TOKEN;
        } else if (request.getMethod().equals("PUT")) {
            requiredToken = WRITE_TOKEN;
        } else if (request.getMethod().equals("DELETE")) {
            requiredToken = WRITE_TOKEN;
        }
        if (providedToken != null && requiredToken != null && providedToken.equals("Bearer " + requiredToken)) {
                filterChain.doFilter(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}