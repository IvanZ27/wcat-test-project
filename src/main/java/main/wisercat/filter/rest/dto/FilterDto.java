package main.wisercat.filter.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FilterDto implements DtoEntity {

    private Integer id;
    private String filterName;
    private Integer criteriaId;
    private Integer conditionId;
    private Integer amountValue;
    private String titleValue;
    private LocalDate dateValue;
    private Integer selection;

}