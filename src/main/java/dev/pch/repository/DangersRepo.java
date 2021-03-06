package dev.pch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.pch.domains.Dangers;

/* Définition des requêtes utilisées dans le contrôleur de Dangers */

public interface DangersRepo extends JpaRepository<Dangers, Integer> {

	Optional<Dangers> findByNom(String nom);

	Optional<Dangers> findById(int id);

}
