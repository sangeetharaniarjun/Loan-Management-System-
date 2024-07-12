package kivi.lms.repository;

import kivi.lms.model.collection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollectionRepository extends JpaRepository<collection, Integer> {

}