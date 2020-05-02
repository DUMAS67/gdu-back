package dev.pch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.pch.domains.Gravite;

public interface GraviteRepo extends JpaRepository<Gravite, Integer> {

	
	Optional<Gravite> findByValeur(int valeur);

	Optional<Gravite> findById(int id);
	
}
