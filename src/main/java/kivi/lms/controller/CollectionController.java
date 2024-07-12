package kivi.lms.controller;

import kivi.lms.model.collection;
import kivi.lms.model.loan;
import kivi.lms.model.repayment;
import kivi.lms.repository.CollectionRepository;
import kivi.lms.repository.LoanRepository;
import kivi.lms.repository.RepaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/lms/collection")

public class CollectionController {
    @Autowired
    private CollectionRepository collectionRepository;
    @Autowired
    private RepaymentRepository repaymentRepository;
    @Autowired
    private LoanRepository loanRepository;


    @GetMapping
    public List<collection> getAllCollections() {
        return collectionRepository.findAll();
    }

    //    @PostMapping
//    public collection createcollection(@RequestBody collection cln) {
//
//        collection savedCollection= collectionRepository.save(cln);
//        Optional<repayment> repayment=repaymentRepository.findById(cln.getRepaymentid());
//        repayment.get().setStatus("Paid");
//        repaymentRepository.save(repayment);
////        return repaymentRepository.save("repayment");
//        return savedCollection;
//
//
//    }
    @PostMapping
    public collection createcollection(@RequestBody collection cln) {
        collection savedCollection = collectionRepository.save(cln);

        //Update repayment status to "Paid"
        Optional<repayment> optionalRepayment = repaymentRepository.findById(cln.getRepaymentid());
        if (optionalRepayment.isPresent()) {
            repayment repayment = optionalRepayment.get();
            repayment.setStatus("Paid");
            repaymentRepository.save(repayment);
        }

        if (cln.getCollectiondate() != null) {
            Optional<repayment> optionalRepaymentForDate = repaymentRepository.findById(cln.getRepaymentid());
            if (optionalRepaymentForDate.isPresent()) {
                repayment repayment = optionalRepaymentForDate.get();
                repayment.setCollectiondate(cln.getCollectiondate());
                repaymentRepository.save(repayment);
            }
        }

        if (cln.getRepaymentid() != null && cln.getTotalcollected() != null) {
            Optional<loan> optionalLoan = loanRepository.findById(cln.getLoanid());
            optionalLoan.ifPresent(loan -> {
                if (loan.getRepaymentsopen() != null && loan.getPrincipaloutstanding() != null) {
                    int repaymentsOpen = loan.getRepaymentsopen();
                    double outstandingPrincipal = loan.getPrincipaloutstanding();

                    // Decrement repaymentsOpen by 1
                    loan.setRepaymentsopen(repaymentsOpen - 1);

                    // Decrement outstandingPrincipal by the amount collected
                    loan.setPrincipaloutstanding(outstandingPrincipal - cln.getPrincipal());

                    loanRepository.save(loan);
                }
            });


        }
        return savedCollection;
    }
}


//    @GetMapping("{collectionid}")
//    public ResponseEntity<Optional<collection>> getcollection(@PathVariable int collectionid){
//        Optional<collection> cln=collectionRepository.findById(collectionid);
//        return ResponseEntity.ok(cln);
//    }


//    @DeleteMapping("/{collectionId}")
//    public ResponseEntity<String> deleteCollection(@PathVariable int collectionId) {
//        Optional<collection> cln = collectionRepository.findById(collectionId);
//        if (cln.isPresent()) {
//            collectionRepository.deleteById(collectionId);
//            return ResponseEntity.ok("Collection with ID " + collectionId + " deleted successfully");
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }


//    @PatchMapping("/{repaymentId}")
//    public ResponseEntity<String> updateRepaymentPartially(@PathVariable int repaymentId, @RequestBody Map<String, Object> updates) {
//        Optional<repayment> optionalRepayment = repaymentRepository.findById(repaymentId);
////        if (optionalRepayment.isPresent()) {
//        repayment repayment = optionalRepayment.get();
////            // Apply partial updates from the request body
////            updates.forEach((key, value) -> {
////                // Handle each field update as needed
////                switch (key) {
////                    case "status":
//        repayment.setStatus((String) "Paid");
////                        break;
//        repaymentRepository.save(repayment);
//        return ResponseEntity.ok("repayment");
//    }