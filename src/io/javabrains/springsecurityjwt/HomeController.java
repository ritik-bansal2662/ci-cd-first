// 
// Decompiled by Procyon v0.5.36
// 

package io.javabrains.springsecurityjwt;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;

import io.javabrains.springsecurityjwt.model.AuthenticationResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import io.javabrains.springsecurityjwt.model.AuthenticationRequest;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;

import io.javabrains.springsecurityjwt.model.Users;
import io.javabrains.springsecurityjwt.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController
{
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
      UserRepository userrepo;
    String userdetailsinfo;
    
    public HomeController() {
        this.userdetailsinfo = null;
    }
    
    @RequestMapping(value = { "/userdetails" }, method = { RequestMethod.GET })
    public Users hello() {
        return this.userrepo.findByUserName(this.userdetailsinfo);
    }
    
    @RequestMapping(value = { "/authenticates" }, method = { RequestMethod.POST })
    public ResponseEntity<?> createAuthenticationToken(@RequestBody final AuthenticationRequest authenticationRequest) throws Exception {
    	Date date = new java.util.Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    	//System.out.println(sdf.format(date));
    	Date current = sdf.parse(sdf.format(date));
    	//Date current = sdf.parse("08:01");
    	Date twelve = sdf.parse("24:59");
    	Date eight = sdf.parse("8:00");
	    //if (current.before(twelve) && current.after(eight)) {
	    if (true) {
	    	System.out.println("before twelve and eight");
    	try {
            this.authenticationManager.authenticate((Authentication)new UsernamePasswordAuthenticationToken((Object)authenticationRequest.getUsername(), (Object)authenticationRequest.getPassword()));
 
    	 }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect Username or Password", (Throwable)e);
        }
	    }
	    else
	    {
	    	System.out.println("between twelve and eight");
	    	throw new Exception();
	    	 
	    }
        final UserDetails userDetails = this.userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        this.userdetailsinfo = String.valueOf(userDetails.getUsername());
        System.out.println("UserDetails::::::: " + this.userdetailsinfo);
        final String jwt = this.jwtUtil.generateToken(userDetails);
        System.out.println("JWT Token::::::" + jwt);
        return (ResponseEntity<?>)ResponseEntity.ok((Object)new AuthenticationResponse(jwt));
    }
}
