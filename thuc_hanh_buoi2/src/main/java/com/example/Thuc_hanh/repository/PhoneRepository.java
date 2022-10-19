package com.example.Thuc_hanh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Thuc_hanh.model.Phone;

public interface PhoneRepository extends JpaRepository<Phone, String> {
	public Phone findPhoneById(String id);
}
