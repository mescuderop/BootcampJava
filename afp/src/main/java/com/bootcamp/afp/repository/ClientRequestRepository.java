package com.bootcamp.afp.repository;

import com.bootcamp.afp.domain.ClientRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRequestRepository extends JpaRepository<ClientRequest, Long> {
}
