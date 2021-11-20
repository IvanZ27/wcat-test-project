package main.wisercat.filter.rest.service;


import main.wisercat.filter.persistance.entity.Filter;
import main.wisercat.filter.persistance.repo.FilterRepository;
import main.wisercat.filter.rest.dto.FilterDto;
import main.wisercat.filter.utils.DtoUtils;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FilterService {

    private final FilterRepository filterRepository;

    public FilterService(FilterRepository filterRepository) {
        this.filterRepository = filterRepository;
    }

    public List<Filter> getFilters() {
        return filterRepository.findAll();
    }

    public Filter saveFilter(Filter filter) {
        if (filter == null) {
            return null;
        }

        return filterRepository.save(filter);
    }

    public Filter saveFilter(FilterDto filterDto) {
        if (filterDto == null) {
            return null;
        }

        Filter filter = DtoUtils.convertToEntity(filterDto, Filter.class);
        return saveFilter(filter);
    }
}
