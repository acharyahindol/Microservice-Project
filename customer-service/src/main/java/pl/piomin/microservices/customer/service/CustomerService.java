package pl.piomin.microservices.customer.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.piomin.microservices.customer.exceptions.CustomerNotFoundException;
import pl.piomin.microservices.customer.intercomm.AccountClient;
import pl.piomin.microservices.customer.model.Account;
import pl.piomin.microservices.customer.model.Customer;
import pl.piomin.microservices.customer.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final AccountClient accountClient;

    public CustomerService(CustomerRepository customerRepository, AccountClient accountClient) {
        this.customerRepository = customerRepository;
        this.accountClient = accountClient;
    }

    @Transactional(readOnly = true)
    public Customer findByPesel(String pesel) throws CustomerNotFoundException {
        return customerRepository.findByPesel(pesel)
                .orElseThrow(() -> new CustomerNotFoundException("pesel : " + pesel));
    }

    @Transactional(readOnly = true)
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Customer findById(Integer id) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("id : " + id));
        List<Account> accounts = accountClient.getAccounts(id);
        customer.setAccounts(accounts);
        return customer;
    }

    @Transactional
    public Customer createNewCustomer(Customer customer) {
        customer.setId(null);
        return customerRepository.save(customer);
    }

    @Transactional
    public boolean deleteCustomer(Integer id) {
        if (!customerRepository.existsById(id)) {
            return false;
        }
        customerRepository.deleteById(id);
        return true;
    }
}
