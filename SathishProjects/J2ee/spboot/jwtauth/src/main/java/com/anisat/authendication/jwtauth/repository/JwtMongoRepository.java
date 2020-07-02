package com.anisat.authendication.jwtauth.repository;

import com.anisat.authendication.jwtauth.repository.dao.UserDao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JwtMongoRepository extends MongoRepository<UserDao, String> {
    UserDao findByUserName(String userName);
    UserDao findByEmailId(String emailId);
    UserDao findByFirstName(String firstName);
    UserDao findByLastName(String lastName);
}
