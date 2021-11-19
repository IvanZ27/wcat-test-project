package main.wisercat.filter.persistance.repo;

import main.wisercat.filter.persistance.entity.Filter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilterRepository extends JpaRepository<Filter, Integer> {

}
