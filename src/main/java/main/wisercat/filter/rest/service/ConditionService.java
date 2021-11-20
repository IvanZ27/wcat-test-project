package main.wisercat.filter.rest.service;

import main.wisercat.filter.persistance.entity.Condition;
import main.wisercat.filter.persistance.entity.Filter;
import main.wisercat.filter.persistance.repo.ConditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ConditionService {

    private final ConditionRepository conditionRepository;

    public ConditionService(ConditionRepository conditionRepository) {
        this.conditionRepository = conditionRepository;
    }

    public List<Condition> getConditions() { return conditionRepository.findAll(); }

}
