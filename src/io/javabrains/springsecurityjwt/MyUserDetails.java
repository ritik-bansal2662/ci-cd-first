// 
// Decompiled by Procyon v0.5.36
// 

package io.javabrains.springsecurityjwt;

import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;
import io.javabrains.springsecurityjwt.model.Users;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails
{
    private static final long serialVersionUID = 1L;
    private String userName;
    private String password;
    private String first_name;
    private String last_name;
    private int status;
    private String type_user;
    private String imei_number;
    
    public MyUserDetails() {
    }
    
    public MyUserDetails(final Users user) {
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.first_name = user.getFirst_name();
        this.last_name = user.getLast_name();
        this.imei_number = user.getImei_number();
        this.status = user.getStatus();
        this.type_user = user.getType_user();
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public String getUsername() {
        return this.userName;
    }
    
    public String getFirst_name() {
        return this.first_name;
    }
    
    public String getLast_name() {
        return this.last_name;
    }
    
    public int getStatus() {
        return this.status;
    }
    
    public String getType_user() {
        return this.type_user;
    }
    
    public String getImei_number() {
        return this.imei_number;
    }
    
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
    
    public boolean isAccountNonExpired() {
        return false;
    }
    
    public boolean isAccountNonLocked() {
        return false;
    }
    
    public boolean isCredentialsNonExpired() {
        return false;
    }
    
    public boolean isEnabled() {
        return false;
    }
}
