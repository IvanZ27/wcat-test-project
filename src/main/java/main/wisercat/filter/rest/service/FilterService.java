package main.wisercat.filter.rest.service;


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

        for (FilterDto filterDto : filterDtos) {

            if (filterDto.getCriteriaId() == 1 && filterDto.getTitleValue() != null || filterDto.getCriteriaId() == 1 && filterDto.getDateValue() != null ) {
                return null;
            }

            if (filterDto.getCriteriaId() == 2 && filterDto.getAmountValue() != null || filterDto.getCriteriaId() == 2 && filterDto.getDateValue() != null ) {
                return null;
            }

            if (filterDto.getCriteriaId() == 3 && filterDto.getTitleValue() != null || filterDto.getCriteriaId() == 3 && filterDto.getAmountValue() != null ) {
                return null;
            }

            Filter filterEntity = new Filter();
            filterEntity.setFilterName(filterDto.getFilterName());
            filterEntity.setCriteria(criteriaRepository.findById(filterDto.getCriteriaId()).orElse(null));
            filterEntity.setCondition(conditionRepository.findById(filterDto.getConditionId()).orElse(null));
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
