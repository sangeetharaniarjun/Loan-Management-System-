package kivi.lms.repository;

import kivi.lms.model.repayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepaymentRepository extends JpaRepository<repayment, Integer> {

}