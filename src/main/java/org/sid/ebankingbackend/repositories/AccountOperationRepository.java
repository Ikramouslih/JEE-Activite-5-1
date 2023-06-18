package org.sid.ebankingbackend.repositories;

import org.sid.ebankingbackend.dtos.BankAccountDTO;
import org.sid.ebankingbackend.entitites.AccountOperation;
import org.sid.ebankingbackend.entitites.BankAccount;
import org.sid.ebankingbackend.entitites.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountOperationRepository extends JpaRepository<AccountOperation,Long> {
    List<AccountOperation> findByBankAccountId(String accountId);
    Page<AccountOperation> findByBankAccountId(String accountId, Pageable pageable);
}

