package pl.piomin.microservices.customer.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.piomin.microservices.customer.exceptions.CustomerNotFoundException;
import pl.piomin.microservices.customer.model.Customer;
import pl.piomin.microservices.customer.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customers")
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/pesel/{pesel}")
    public Customer findByPesel(@PathVariable("pesel") String pesel) throws CustomerNotFoundException {
        log.info(String.format("Customer.findByPesel(%s)", pesel));
        return customerService.findByPesel(pesel);
    }

    @RequestMapping(method = RequestMethod.GET, value = "")
    public List<Customer> findAll() {
        log.info("Customer.findAll()");
        return customerService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Customer findById(@PathVariable("id") Integer id) throws CustomerNotFoundException {
        log.info(String.format("Customer.findById(%s)", id));
        return customerService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public Customer createNewCustomer(@RequestBody Customer customer) {
        log.info("Customer.createNewCustomer()");
        return customerService.createNewCustomer(customer);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public boolean deleteCustomer(@PathVariable Integer id) {
        log.info("Customer.deleteCustomer()");
        return customerService.deleteCustomer(id);
    }

}
