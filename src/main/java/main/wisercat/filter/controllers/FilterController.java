package main.wisercat.filter.controllers;


import main.wisercat.filter.persistance.entity.Filter;
import main.wisercat.filter.rest.dto.FilterDto;
import main.wisercat.filter.rest.service.FilterService;
import main.wisercat.filter.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FilterController {

    @Autowired
    private FilterService filterService;

    @GetMapping("ui/filter")
    public ResponseEntity<List<FilterDto>> getFilters() {
        List<Filter> filters = filterService.getFilters();
        List<FilterDto> filterDtos = filters.stream().map(e -> DtoUtils.convertToDto(e, FilterDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(filterDtos, HttpStatus.OK);
    }

    @PostMapping("ui/filter")
    public ResponseEntity<FilterDto> saveFilters(@RequestBody FilterDto filterDto) {
        filterDto.setId(null);
        Filter newFilter = filterService.saveFilter(filterDto);
        FilterDto newFilterDto = DtoUtils.convertToDto(newFilter, FilterDto.class);
        return new ResponseEntity<>(newFilterDto, newFilterDto == null ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
    }
}
