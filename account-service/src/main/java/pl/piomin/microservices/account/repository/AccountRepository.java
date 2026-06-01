package pl.piomin.microservices.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piomin.microservices.account.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    Optional<Account> findByNumber(String number);

    List<Account> findByCustomerId(Integer customerId);
}
