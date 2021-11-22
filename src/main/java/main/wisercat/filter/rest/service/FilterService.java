package main.wisercat.filter.rest.service;


import main.wisercat.filter.persistance.entity.Condition;
import main.wisercat.filter.persistance.entity.Criteria;
import main.wisercat.filter.persistance.entity.Filter;
import main.wisercat.filter.persistance.repo.ConditionRepository;
import main.wisercat.filter.persistance.repo.CriteriaRepository;
import main.wisercat.filter.persistance.repo.FilterRepository;
import main.wisercat.filter.rest.dto.FilterDto;
import main.wisercat.filter.utils.DtoUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class FilterService {

    private final CriteriaRepository criteriaRepository;
    private final ConditionRepository conditionRepository;
    private final FilterRepository filterRepository;

    public FilterService(FilterRepository filterRepository, CriteriaRepository criteriaRepository, ConditionRepository conditionRepository) {
        this.filterRepository = filterRepository;
        this.criteriaRepository = criteriaRepository;
        this.conditionRepository = conditionRepository;
    }

    public List<Filter> getFilters() {
        return filterRepository.findAll();
    }

    public List<FilterDto> saveFilter(List<FilterDto> filterDtos) {
        ArrayList<FilterDto> newFilterDtos = new ArrayList<>();

        FilterDto firstFilterDto = filterDtos.get(0);

        Integer criteriaId = firstFilterDto.getCriteriaId();
        Integer conditionId = firstFilterDto.getConditionId();

        Criteria criteria = criteriaRepository.findById(criteriaId).orElse(null);
        Condition condition = conditionRepository.findById(conditionId).orElse(null);

        for (FilterDto filterDto : filterDtos) {
            if (!criteriaId.equals(filterDto.getCriteriaId()) ||
                    !conditionId.equals(filterDto.getConditionId())) {
                return null;
            }

            Filter filterEntity = new Filter();
            filterEntity.setFilterName(filterDto.getFilterName());
            filterEntity.setCriteria(criteria);
            filterEntity.setCondition(condition);
            filterEntity.setAmountValue(filterDto.getAmountValue());
            filterEntity.setTitleValue(filterDto.getTitleValue());
            filterEntity.setDateValue(filterDto.getDateValue());
            filterEntity.setSelection(filterDto.getSelection());

            newFilterDtos.add(DtoUtils.convertToDto(filterRepository.save(filterEntity),
                    FilterDto.class));
        }
        return newFilterDtos;
    }
}
