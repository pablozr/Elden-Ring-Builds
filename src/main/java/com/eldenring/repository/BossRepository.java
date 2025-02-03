package com.eldenring.repository;

import com.eldenring.model.Bosses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BossRepository extends JpaRepository<Bosses, Long> {
    Optional<Bosses> findByNome(String nome);
}
