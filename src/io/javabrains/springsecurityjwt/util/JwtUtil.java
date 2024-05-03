// 
// Decompiled by Procyon v0.5.36
// 

package io.javabrains.springsecurityjwt.util;

import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Map;
import java.util.HashMap;
import org.springframework.security.core.userdetails.UserDetails;
import io.jsonwebtoken.Jwts;
import java.util.function.Function;
import java.util.Date;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Service;

@Service
public class JwtUtil
{
    private String SECRET_KEY;
    
    public JwtUtil() {
        this.SECRET_KEY = "secret";
    }
    
    public String extractUsername(final String token) {
        return this.extractClaim(token, Claims::getSubject);
    }
    
    public Date extractExpiration(final String token) {
        return this.extractClaim(token, Claims::getExpiration);
    }
    
    public <T> T extractClaim(final String token, final Function<Claims, T> claimsResolver) {
        final Claims claims = this.extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    
    private Claims extractAllClaims(final String token) {
        return (Claims)Jwts.parser().setSigningKey(this.SECRET_KEY).parseClaimsJws(token).getBody();
    }
    
    private Boolean isTokenExpired(final String token) {
        return this.extractExpiration(token).before(new Date());
    }
    
    public String generateToken(final UserDetails userDetails) {
        final Map<String, Object> claims = new HashMap<String, Object>();
        return this.createToken(claims, userDetails.getUsername());
    }
    
    private String createToken(final Map<String, Object> claims, final String subject) {
        return Jwts.builder().setClaims((Map)claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + 1728000000L)).signWith(SignatureAlgorithm.HS256, this.SECRET_KEY).compact();
    }
    
    public Boolean validateToken(final String token, final UserDetails userDetails) {
        final String username = this.extractUsername(token);
        if (username.equals(userDetails.getUsername()) && !this.isTokenExpired(token)) {
            return true;
        }
        return false;
    }
}
