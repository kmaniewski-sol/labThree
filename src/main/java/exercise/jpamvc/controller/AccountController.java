package exercise.jpamvc.controller;

import exercise.jpamvc.domain.Account;
import exercise.jpamvc.service.AccountService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private AccountService accountService;

    AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping(path="/account/retrieve/{id}")
    public Account retrieve(@PathVariable("id") Long id){
        return accountService.retrieve(id);
    }

    @DeleteMapping(path="/account/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        accountService.delete(id);
    }
}
