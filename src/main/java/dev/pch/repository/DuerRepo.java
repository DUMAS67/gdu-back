/**
 * 
 */
package dev.pch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.pch.domains.Duer;

/**
 * @author Thierry Dumas
 *
 */
public interface DuerRepo extends JpaRepository<Duer, Integer> {

}
