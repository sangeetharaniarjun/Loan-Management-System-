package kivi.lms.repository;

import kivi.lms.model.demand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandRepository extends JpaRepository<demand,Integer> {

}