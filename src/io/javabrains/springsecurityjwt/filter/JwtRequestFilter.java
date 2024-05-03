// 
// Decompiled by Procyon v0.5.36
// 

package io.javabrains.springsecurityjwt.filter;

import java.io.IOException;
import javax.servlet.ServletException;
import org.springframework.security.core.userdetails.UserDetails;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import io.javabrains.springsecurityjwt.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import io.javabrains.springsecurityjwt.util.JwtUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

@Service
public class JwtRequestFilter extends OncePerRequestFilter
{
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private MyUserDetailsService userDetailService;
    
    protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response, final FilterChain chain) throws ServletException, IOException {
        final String authoraizationHeader = request.getHeader("Authorization");
        String username = null;
        String jwt = null;
        if (authoraizationHeader != null && authoraizationHeader.startsWith("Bearer ")) {
            jwt = authoraizationHeader.substring(7);
            username = this.jwtUtil.extractUsername(jwt);
        }
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            final UserDetails userDetails = this.userDetailService.loadUserByUsername(username);
            if (this.jwtUtil.validateToken(jwt, userDetails)) {
                final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken((Object)userDetails, (Object)null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails((Object)new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication((Authentication)usernamePasswordAuthenticationToken);
            }
        }
        chain.doFilter((ServletRequest)request, (ServletResponse)response);
    }
}
