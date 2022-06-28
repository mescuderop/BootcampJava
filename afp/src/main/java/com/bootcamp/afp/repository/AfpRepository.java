package com.bootcamp.afp.repository;

import com.bootcamp.afp.domain.Afp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AfpRepository extends JpaRepository<Afp, Long> {
}
