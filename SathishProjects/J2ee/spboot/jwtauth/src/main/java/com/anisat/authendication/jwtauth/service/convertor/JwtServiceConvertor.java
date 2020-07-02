package com.anisat.authendication.jwtauth.service.convertor;

import com.anisat.authendication.jwtauth.controller.model.UserModel;
import com.anisat.authendication.jwtauth.repository.dao.UserDao;
import com.anisat.authendication.jwtauth.service.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface JwtServiceConvertor {

    UserModel getUserModelFromDto(UserDto userDto);
    UserDto getUserDtoFromModel(UserModel userModel);

    UserDao getUserDaoFromDto(UserDto userDto);
    UserDto getUserDtoFromDao(UserDao userDao);


    default public Set<GrantedAuthority> getGrantedAuthorities(List<String> authorities) {
        Set<GrantedAuthority> simpleGrantedAuthorityList = authorities
                .stream().map(authority -> {
                    SimpleGrantedAuthority authorityObject = new SimpleGrantedAuthority(authority);
                    return authorityObject;
                }).collect(Collectors.toSet());
        return simpleGrantedAuthorityList;
    }

    default public List<String> getGrantedAuthorityAsString(Set<GrantedAuthority> grantedAuthorities) {
        List<String> grantedAuthList = grantedAuthorities.stream().map(auth -> {
            return auth.getAuthority();
        }).collect(Collectors.toList());
        return grantedAuthList;
    }

}
