package main.wisercat.filter.controllers;

import main.wisercat.filter.persistance.entity.Criteria;
import main.wisercat.filter.rest.dto.CriteriaDto;
import main.wisercat.filter.rest.service.CriteriaService;
import main.wisercat.filter.utils.DtoUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
public class CriteriaController {

    private final CriteriaService criteriaService;

    public CriteriaController(CriteriaService criteriaService) {
        this.criteriaService = criteriaService;
    }

    @GetMapping("ui/criteria")
    public ResponseEntity<List<CriteriaDto>> getFilters() {
        List<Criteria> filters = criteriaService.getCriteries();
        List<CriteriaDto> criteriaDtos = filters.stream().map(e -> DtoUtils.convertToDto(e, CriteriaDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(criteriaDtos, HttpStatus.OK);
    }
}
