package com.bootcamp.afp.repository;

import com.bootcamp.afp.domain.ClientAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientAccountRepository extends JpaRepository<ClientAccount, Long> {
}
