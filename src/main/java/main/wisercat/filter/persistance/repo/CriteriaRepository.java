package main.wisercat.filter.persistance.repo;

import main.wisercat.filter.persistance.entity.Criteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriteriaRepository extends JpaRepository<Criteria, Integer> {

}
