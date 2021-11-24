package main.wisercat.filter.rest.service;

import main.wisercat.filter.persistance.entity.Criteria;
import main.wisercat.filter.persistance.repo.CriteriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CriteriaService {

    private final CriteriaRepository criteriaRepository;

    public CriteriaService(CriteriaRepository criteriaRepository) {
        this.criteriaRepository = criteriaRepository;
    }

    public List<Criteria> getCriteries() {
        return criteriaRepository.findAll();
    }

}
