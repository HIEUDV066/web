package com.example.TH2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TH2.model.Books;


public interface BookRepository extends JpaRepository<Books, Integer> {
	Optional<Books> findByTitle(String title);
}
