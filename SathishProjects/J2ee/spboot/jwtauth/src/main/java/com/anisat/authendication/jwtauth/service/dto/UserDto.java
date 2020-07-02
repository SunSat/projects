package com.anisat.authendication.jwtauth.service.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String phoneNo;
    private String password;
    private String userName;
    private List<String> authorities;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
}
