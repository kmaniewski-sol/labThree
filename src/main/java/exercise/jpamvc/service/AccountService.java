package exercise.jpamvc.service;

import exercise.jpamvc.domain.Account;
import exercise.jpamvc.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public Account save(Account account){
        return accountRepository.save(account);
    }

    public Account retrieve(Long id) {
        return accountRepository.getById(id);
    }

    public void delete(Long id) {
        accountRepository.delete(id);
    }
}
