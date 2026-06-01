package pl.piomin.microservices.account.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.piomin.microservices.account.exceptions.AccountNotFoundException;
import pl.piomin.microservices.account.model.Account;
import pl.piomin.microservices.account.repository.AccountRepository;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional(readOnly = true)
    public Account findByNumber(String number) throws AccountNotFoundException {
        return accountRepository.findByNumber(number)
                .orElseThrow(() -> new AccountNotFoundException("number : " + number));
    }

    @Transactional(readOnly = true)
    public List<Account> findByCustomer(Integer customerId) {
        return accountRepository.findByCustomerId(customerId);
    }

    @Transactional(readOnly = true)
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Account findById(Integer id) throws AccountNotFoundException {
        return accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("id : " + id));
    }

    @Transactional
    public Account createNewAccount(Account account) {
        account.setId(null);
        return accountRepository.save(account);
    }

    @Transactional
    public boolean deleteAccount(Integer id) {
        if (!accountRepository.existsById(id)) {
            return false;
        }
        accountRepository.deleteById(id);
        return true;
    }
}
