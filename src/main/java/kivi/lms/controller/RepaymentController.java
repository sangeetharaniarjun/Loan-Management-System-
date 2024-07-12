package kivi.lms.controller;

import kivi.lms.model.customer;
import kivi.lms.model.loan;
import kivi.lms.model.repayment;
import kivi.lms.repository.RepaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lms/repayment")
public class RepaymentController
{
    @Autowired
    private RepaymentRepository repaymentRepository;
    @GetMapping
    public List<repayment> getAllRepayments()
    {
        return repaymentRepository.findAll();
    }

    @PostMapping
    public repayment createrepayment(@RequestBody repayment rn) {
        return repaymentRepository.save(rn);
    }

    @GetMapping("{repaymentid}")
    public ResponseEntity<Optional<repayment>> getrepayment(@PathVariable int repaymentid){
        Optional<repayment> rpmt=repaymentRepository.findById(repaymentid);
        return ResponseEntity.ok(rpmt);
    }


    @DeleteMapping("/{repaymentId}")
    public ResponseEntity<String> deleteRepayment(@PathVariable int repaymentId) {
        Optional<repayment> rpmt = repaymentRepository.findById(repaymentId);
        if (rpmt.isPresent()) {
            repaymentRepository.deleteById(repaymentId);
            return ResponseEntity.ok("Repayment with ID " + repaymentId + " deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}