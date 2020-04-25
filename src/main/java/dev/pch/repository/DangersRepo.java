package dev.pch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.pch.domains.Dangers;

public interface DangersRepo extends JpaRepository<Dangers, Integer> {

}
