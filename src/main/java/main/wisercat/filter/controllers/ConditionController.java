package main.wisercat.filter.controllers;

import main.wisercat.filter.persistance.entity.Condition;
import main.wisercat.filter.rest.dto.ConditionDto;
import main.wisercat.filter.rest.service.ConditionService;
import main.wisercat.filter.utils.DtoUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
public class ConditionController {

    private final ConditionService conditionService;

    public ConditionController(ConditionService conditionService) {
        this.conditionService = conditionService;
    }

    @GetMapping("ui/condition")
    public ResponseEntity<List<ConditionDto>> getConditions() {
        List<Condition> conditions = conditionService.getConditions();
        List<ConditionDto> conditionDtos = conditions.stream().map(e -> DtoUtils.convertToDto(e, ConditionDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(conditionDtos, HttpStatus.OK);
    }
}
