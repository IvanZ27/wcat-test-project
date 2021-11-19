package main.wisercat.filter.rest.service;


import main.wisercat.filter.persistance.entity.Filter;
import main.wisercat.filter.persistance.repo.FilterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilterService {

    private final FilterRepository filterRepository;


    public FilterService(FilterRepository filterRepository) {
        this.filterRepository = filterRepository;
    }

    public List<Filter> getFilters() { return filterRepository.findAll(); }

}
