package com.securityjwt.jwt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.securityjwt.jwt.entity.UserInformation;

public interface UserJpaRepository extends JpaRepository<UserInformation, String>{

}
