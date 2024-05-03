// 
// Decompiled by Procyon v0.5.36
// 

package io.javabrains.springsecurityjwt;

import io.javabrains.springsecurityjwt.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer>
{
    Users findByUserName(final String userName);
}
