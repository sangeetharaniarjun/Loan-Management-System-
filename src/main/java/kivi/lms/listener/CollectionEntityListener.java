package kivi.lms.listener;

import jakarta.persistence.PostPersist;
import kivi.lms.model.collection;
import kivi.lms.model.repayment;
import kivi.lms.repository.RepaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CollectionEntityListener
{

    private RepaymentRepository repaymentRepository;

    @Autowired
    public CollectionEntityListener(RepaymentRepository repaymentRepository) {
        this.repaymentRepository = repaymentRepository;
    }

    @PostPersist
    public void handlePostPersist(collection collection) {
        // Retrieve the repayment record associated with the collection
        Optional<repayment> optionalRepayment = repaymentRepository.findById(collection.getRepaymentid());
        if (optionalRepayment.isPresent()) {
            repayment repayment = optionalRepayment.get();
            // Update the status to "Paid"
            repayment.setStatus("Paid");
            repaymentRepository.save(repayment);
        }
    }
}