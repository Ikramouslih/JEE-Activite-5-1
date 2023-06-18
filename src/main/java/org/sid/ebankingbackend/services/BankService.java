package org.sid.ebankingbackend.services;

import jakarta.transaction.Transactional;
import org.sid.ebankingbackend.entitites.BankAccount;
import org.sid.ebankingbackend.entitites.CurrentAccount;
import org.sid.ebankingbackend.entitites.SavingAccount;
import org.sid.ebankingbackend.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BankService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    public void consulter() {
        BankAccount bankAccount = bankAccountRepository.findById("16ee3160-e730-4908-a910-040b5b89834d").orElse(null);
        if (bankAccount != null) {
            System.out.println("***************************");
            System.out.println(bankAccount.getId());
            System.out.println(bankAccount.getBalance());
            System.out.println(bankAccount.getStatus());
            System.out.println(bankAccount.getCreatedAt());
            System.out.println(bankAccount.getCustomer().getName());
            if (bankAccount instanceof CurrentAccount) {
                System.out.println("OverDraft => " + (((CurrentAccount) bankAccount).getOverDraft()));
            } else if (bankAccount instanceof SavingAccount) {
                System.out.println("Rate => " + (((SavingAccount) bankAccount).getInterestRate()));
            }
            bankAccount.getAccountOperations().forEach(op -> {
                System.out.println("=======================");
                System.out.println(op.getType() + "\t" + op.getOperationDate() + "\t" + op.getAmount());
            });
        }
    }
}
