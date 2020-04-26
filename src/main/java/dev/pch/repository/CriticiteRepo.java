package dev.pch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.pch.domains.Criticite;

public interface CriticiteRepo extends JpaRepository<Criticite, Integer> {

	Optional<Criticite> findByValeur(int valeur);

	Optional<Criticite> findById(int id);

}
