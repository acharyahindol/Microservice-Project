package pl.piomin.microservices.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piomin.microservices.customer.model.Customer;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByPesel(String pesel);
}
