package com.anisat.authendication.jwtauth.controller.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@JsonSerialize
public class UserModel {
    String userName;
    String password;
    List<String> authorities;
    String firstName;
    String lastName;
    String emailId;
    String phoneNo;
}
