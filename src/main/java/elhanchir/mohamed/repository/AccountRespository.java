package elhanchir.mohamed.repository;

import elhanchir.mohamed.model.BankAccount;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface AccountRespository {
    BankAccount save(BankAccount bankAccount);
    Optional<BankAccount> findById(Long accountId);
    List<BankAccount> findAll();
    void delete(Long accountId);
    List<BankAccount> searchAccounts(Predicate<BankAccount> predicate);
    BankAccount update(BankAccount bankAccount);
}
