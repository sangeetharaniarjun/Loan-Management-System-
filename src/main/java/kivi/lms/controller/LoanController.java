package kivi.lms.controller;

import kivi.lms.model.customer;
import kivi.lms.model.loan;
import kivi.lms.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/lms/loan")
public class LoanController
{
    @Autowired
    private LoanRepository loanRepository;
    @GetMapping
    public List<loan> getAllLoans()
    {
        return loanRepository.findAll();
    }

//    @GetMapping("{loanid}")
//    public ResponseEntity<Optional<loan>> getloan(@PathVariable int loanid){
//        Optional<loan> ln=LoanRepository.findById(loanid);
//        return ResponseEntity.ok(ln);
//    }

    @PostMapping
    public loan createloan(@RequestBody loan ln) {
        return loanRepository.save(ln);
    }

    @GetMapping("{loanid}")
    public ResponseEntity<Optional<loan>> getloan(@PathVariable int loanid){
        Optional<loan> ln=loanRepository.findById(loanid);
        return ResponseEntity.ok(ln);
    }

    @DeleteMapping("/{loanId}")
    public ResponseEntity<String> deleteLoan(@PathVariable int loanId) {
        Optional<loan> ln = loanRepository.findById(loanId);
        if (ln.isPresent()) {
            loanRepository.deleteById(loanId);
            return ResponseEntity.ok("Loan with ID " + loanId + " deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{loanId}")
    public ResponseEntity<String> updateLoanPartially(@PathVariable int loanId, @RequestBody Map<String, Object> updates) {
        Optional<loan> optionalLoan = loanRepository.findById(loanId);
        if (optionalLoan.isPresent()) {
            loan loan = optionalLoan.get();
            // Apply partial updates from the request body
            updates.forEach((key, value) -> {
                // Handle each field update as needed
                switch (key) {
                    case "loanamount":
                        loan.setLoanamount((Double) value);
                        break;
                    case "interestrate":
                        loan.setInterestrate((Float) value);
                        break;
                    case "tenure":
                        loan.setTenure((Integer) value);
                        break;
                    case "loanstatus":
                        loan.setLoanstatus((String) value);
                        break;
                    case "principalamount":
                        loan.setPrincipaloutstanding((Double) value);
                        break;
                    // Add cases for other fields to update...
                }
            });
            // Save the updated loan
            loanRepository.save(loan);
            return ResponseEntity.ok("Loan with ID " + loanId + " updated partially successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}