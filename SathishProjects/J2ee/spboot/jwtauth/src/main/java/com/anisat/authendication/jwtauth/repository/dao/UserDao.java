package com.anisat.authendication.jwtauth.repository.dao;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserDao {

    @Id
    String id;
    String firstName;
    String lastName;
    String emailId;
    String phoneNo;
    private String password;
    private String userName;
    private List<String> authorities;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

}
