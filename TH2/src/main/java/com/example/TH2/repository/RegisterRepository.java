package com.example.TH2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TH2.model.User;

public interface RegisterRepository extends JpaRepository<User, Integer> {
	Optional<User> findByName(String name);
}
