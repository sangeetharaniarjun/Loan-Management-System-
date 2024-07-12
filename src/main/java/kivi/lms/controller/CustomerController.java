package kivi.lms.controller;


import kivi.lms.model.customer;
import kivi.lms.model.loan;
import kivi.lms.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lms/customer")
public class CustomerController
{
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<customer> getAllCustomer() {
        return customerRepository.findAll();
    }


    @GetMapping("{customerid}")
    public ResponseEntity<Optional<customer>> getcustomer(@PathVariable int customerid){
        Optional<customer> cust=customerRepository.findById(customerid);
        return ResponseEntity.ok(cust);
    }
    @PostMapping
    public customer createcustomer(@RequestBody customer customer) {
        return customerRepository.save(customer);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<String> deleteLoan(@PathVariable int customerId) {
        Optional<customer> cust = customerRepository.findById(customerId);
        if (cust.isPresent()) {
            customerRepository.deleteById(customerId);
            return ResponseEntity.ok("Customer with ID " + customerId + " deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}