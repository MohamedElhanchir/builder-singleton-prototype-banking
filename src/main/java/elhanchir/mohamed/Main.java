package elhanchir.mohamed;

import elhanchir.mohamed.enums.AccountStatus;
import elhanchir.mohamed.enums.AccountType;
import elhanchir.mohamed.model.BankAccount;
import elhanchir.mohamed.repository.AccountRespositoryImpl;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        AccountRespositoryImpl accountRespository = new AccountRespositoryImpl();
        JsonSerializer<BankAccount> bankAccountJsonSerializer = new JsonSerializer<>();

        accountRespository.populateData2();
        System.out.println("All accounts: ");
        //accountRespository.findAll().forEach(System.out::println);
        accountRespository.findAll().forEach(account -> System.out.println(bankAccountJsonSerializer.serialize(account)));

        System.out.println("Search accounts with balance > 1000: ");
        accountRespository.searchAccounts(account -> account.getBalance() > 1000).forEach(account -> System.out.println(bankAccountJsonSerializer.serialize(account)));

        System.out.println("Search accounts with balance > 1000 and currency = USD: ");
        accountRespository.searchAccounts(account -> account.getBalance() > 1000 && account.getCurrency().equals("USD")).forEach(account -> System.out.println(bankAccountJsonSerializer.serialize(account)));
        /*
        accountRespository.searchAccounts(new Predicate<BankAccount>() {
            @Override
            public boolean test(BankAccount bankAccount) {
                return bankAccount.getBalance() > 1000 && bankAccount.getCurrency().equals("USD");
            }
        }).forEach(account -> System.out.println(bankAccountJsonSerializer.serialize(account)));*/


    }
}