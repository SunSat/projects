package com.anisat.authendication.jwtauth.service;

import com.anisat.authendication.jwtauth.repository.JwtMongoRepository;
import com.anisat.authendication.jwtauth.repository.dao.UserDao;
import com.anisat.authendication.jwtauth.service.convertor.JwtServiceConvertor;
import com.anisat.authendication.jwtauth.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service(value = "userDetailsService")
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    JwtMongoRepository jwtMongoRepository;

    @Autowired
    JwtServiceConvertor jwtServiceConvertor;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDao dao = jwtMongoRepository.findByUserName(username);
        if(dao == null) {
            throw new UsernameNotFoundException("User not found");
        }
        UserDetails userDetails = new User(dao.getUserName(),dao.getPassword(),jwtServiceConvertor.getGrantedAuthorities(dao.getAuthorities()));
        return userDetails;
    }

    public UserDto createNewUser(UserDto userDto) {

        UserDao dao = new UserDao();
        dao.setUserName(userDto.getUserName());
        dao.setPassword(passwordEncoder.encode(userDto.getPassword()));
        dao.setAuthorities(userDto.getAuthorities());
        dao.setEmailId(userDto.getEmailId());
        dao.setFirstName(userDto.getFirstName());
        dao.setLastName(userDto.getLastName());
        dao.setPhoneNo(userDto.getPhoneNo());
        dao = jwtMongoRepository.insert(dao);
        userDto.setId(dao.getId());
        return userDto;
    }

    public UserDto loadByUserName(String userName) {
        UserDao userDao = jwtMongoRepository.findByUserName(userName);
        UserDto userDto = jwtServiceConvertor.getUserDtoFromDao(userDao);
        return userDto;
    }

}
