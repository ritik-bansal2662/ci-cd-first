// 
// Decompiled by Procyon v0.5.36
// 

package io.javabrains.springsecurityjwt.model;

public class AuthenticationResponse
{
    private final String jwt;
    
    public AuthenticationResponse(final String jwt) {
        this.jwt = jwt;
    }
    
    public String getJwt() {
        return this.jwt;
    }
}
