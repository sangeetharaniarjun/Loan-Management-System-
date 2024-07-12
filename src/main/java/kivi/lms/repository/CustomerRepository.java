package kivi.lms.repository;

import kivi.lms.model.customer;
import kivi.lms.model.loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<customer,Integer> {

}