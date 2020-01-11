package com.learn.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.tutorial.model.UserInfo;

public interface UserRepository extends JpaRepository<UserInfo, Long> {

}
