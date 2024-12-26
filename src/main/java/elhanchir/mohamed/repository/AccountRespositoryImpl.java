package elhanchir.mohamed.repository;

import elhanchir.mohamed.enums.AccountStatus;
import elhanchir.mohamed.enums.AccountType;
import elhanchir.mohamed.model.BankAccount;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

public class AccountRespositoryImpl implements AccountRespository {

    private Map<Long, BankAccount> accounts=new HashMap<>();
    private Long accountId=0L;

    @Override
    public BankAccount save(BankAccount bankAccount) {
        bankAccount.setAccountId(++accountId);
        accounts.put(accountId,bankAccount);
        return bankAccount;
    }

    @Override
    public Optional<BankAccount> findById(Long accountId) {
        return Optional.ofNullable(accounts.get(accountId));
    }

    @Override
    public List<BankAccount> findAll() {
        return accounts.values().stream().toList();
    }

    @Override
    public void delete(Long accountId) {
        accounts.remove(accountId);
    }

    @Override
    public List<BankAccount> searchAccounts(Predicate<BankAccount> predicate) {
        return accounts.values().stream().filter(predicate).toList();
    }

    @Override
    public BankAccount update(BankAccount bankAccount) {
        accounts.put(bankAccount.getAccountId(),bankAccount);
        return bankAccount;
    }
/*
    public void populateData1(){
        for (int i = 0; i < 10; i++) {
            BankAccount bankAccount=new BankAccount();
            bankAccount.setBalance(Math.random()*1000+100);
            bankAccount.setCurrency(Math.random()>0.5?"USD":"MAD");
            bankAccount.setAccountType(Math.random()>0.5? AccountType.SAVINGS:AccountType.CURRENT);
            bankAccount.setAccountStatus(AccountStatus.ACTIVATED);
            save(bankAccount);
        }
    }*/

    public void populateData2(){
        for (int i = 0; i < 10; i++) {
            BankAccount bankAccount= BankAccount.builder().
                    balance(Math.random()*1000+100).
                    currency(Math.random()>0.5?"USD":"MAD").
                    accountType(Math.random()>0.5? AccountType.SAVINGS:AccountType.CURRENT).
                    accountStatus(AccountStatus.ACTIVATED).
                    build();

            save(bankAccount);
        }
    }
}
