// 
// Decompiled by Procyon v0.5.36
// 

package io.javabrains.springsecurityjwt.model;

public class AuthenticationRequest
{
    private String username;
    private String password;
    
    public AuthenticationRequest() {
    }
    
    public AuthenticationRequest(final String username, final String password) {
        this.username = username;
        this.password = password;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(final String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(final String password) {
        this.password = password;
    }
}
