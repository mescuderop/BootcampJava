package com.bootcamp.afp.repository;

import com.bootcamp.afp.domain.ClientAfp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientAfpRepository extends JpaRepository<ClientAfp, Long> {
}
