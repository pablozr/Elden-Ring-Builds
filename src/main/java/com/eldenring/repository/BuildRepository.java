package com.eldenring.repository;

import com.eldenring.model.Bosses;
import com.eldenring.model.Builds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildRepository extends JpaRepository<Builds, Long> {
    List<Builds> findBuildsByTipoDanoIn(List<String> tiposDeDano);
}
