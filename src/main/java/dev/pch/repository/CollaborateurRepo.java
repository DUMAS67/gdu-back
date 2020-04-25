package dev.pch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.pch.domains.Collaborateur;

public interface CollaborateurRepo extends JpaRepository<Collaborateur, Integer> {

	Optional<Collaborateur> findByEmail(String email);

}
