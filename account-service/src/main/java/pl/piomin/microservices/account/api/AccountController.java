package pl.piomin.microservices.account.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.piomin.microservices.account.exceptions.AccountNotFoundException;
import pl.piomin.microservices.account.model.Account;
import pl.piomin.microservices.account.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@Slf4j
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/number/{number}")
    public Account findByNumber(@PathVariable("number") String number) throws AccountNotFoundException {
        log.info(String.format("Account.findByNumber(%s)", number));
        return accountService.findByNumber(number);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/customer/{customer}")
    public List<Account> findByCustomer(@PathVariable("customer") Integer customerId) {
        log.info(String.format("Account.findByCustomer(%s)", customerId));
        return accountService.findByCustomer(customerId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "")
    public List<Account> findAll() {
        log.info("Account.findAll()");
        return accountService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Account findById(@PathVariable Integer id) throws AccountNotFoundException {
        log.info("Account.findById()");
        return accountService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public Account createNewAccount(@RequestBody Account account) {
        log.info("Account.createNewAccount()");
        return accountService.createNewAccount(account);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public boolean deleteAccount(@PathVariable Integer id) {
        log.info("Account.deleteAccount()");
        return accountService.deleteAccount(id);
    }

}
