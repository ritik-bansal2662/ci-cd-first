// 
// Decompiled by Procyon v0.5.36
// 

package io.javabrains.springsecurityjwt;

import io.javabrains.springsecurityjwt.model.Users;
import java.util.Collection;
import org.springframework.security.core.userdetails.User;
import java.util.ArrayList;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

@Service
public class MyUserDetailsService implements UserDetailsService
{
    @Autowired
    UserRepository userRepository;
    
    public UserDetails loadUserByUsername(final String userName) throws UsernameNotFoundException {
        final Users user = this.userRepository.findByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + userName);
        }
        return (UserDetails)new User(user.getUserName(), user.getPassword(), (Collection)new ArrayList());
    }
}
