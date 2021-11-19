package main.wisercat.filter.controllers;


import main.wisercat.filter.persistance.entity.Filter;
import main.wisercat.filter.rest.dto.FilterDto;
import main.wisercat.filter.rest.service.FilterService;
import main.wisercat.filter.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FilterController {

    @Autowired
    private FilterService filterService;

    @GetMapping("/filter")
    public ResponseEntity<List<FilterDto>> getFilters() {
        List<Filter> filters = filterService.getFilters();
        List<FilterDto> employeeDtos = filters.stream().map(e -> DtoUtils.convertToDto(e, FilterDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(employeeDtos, HttpStatus.OK);

    }
}
