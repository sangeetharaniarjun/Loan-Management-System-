package kivi.lms.repository;

import kivi.lms.model.loan;
import kivi.lms.model.repayment;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface LoanRepository extends JpaRepository<loan,Integer> {

}