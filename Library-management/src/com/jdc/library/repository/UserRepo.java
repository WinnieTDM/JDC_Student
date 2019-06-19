package com.jdc.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.library.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	User findByLoginId(String loignId);

}
