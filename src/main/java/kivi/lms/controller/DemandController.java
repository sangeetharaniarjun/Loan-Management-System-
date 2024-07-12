package kivi.lms.controller;

import kivi.lms.model.demand;
import kivi.lms.model.repayment;
import kivi.lms.repository.DemandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lms/demand")
public class DemandController
{
    @Autowired
    private DemandRepository demandRepository;
    @GetMapping
    public List<demand> getAllDemands()
    {
        return demandRepository.findAll();
    }

    @PostMapping
    public demand createdemand(@RequestBody demand dmd) {
        return demandRepository.save(dmd);
    }

    @GetMapping("{demandid}")
    public ResponseEntity<Optional<demand>> getdemand(@PathVariable int demandid){
        Optional<demand> dmd=demandRepository.findById(demandid);
        return ResponseEntity.ok(dmd);
    }


    @DeleteMapping("/{demandId}")
    public ResponseEntity<String> deleteDemand(@PathVariable int demandId) {
        Optional<demand> dmd = demandRepository.findById(demandId);
        if (dmd.isPresent()) {
            demandRepository.deleteById(demandId);
            return ResponseEntity.ok("Demand with ID " + demandId + " deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}