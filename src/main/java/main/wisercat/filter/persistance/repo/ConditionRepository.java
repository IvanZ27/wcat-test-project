package main.wisercat.filter.persistance.repo;

import main.wisercat.filter.persistance.entity.Condition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConditionRepository extends JpaRepository<Condition, Integer> {

}
