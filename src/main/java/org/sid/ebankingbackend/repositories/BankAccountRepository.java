package org.sid.ebankingbackend.repositories;

import org.sid.ebankingbackend.entitites.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
