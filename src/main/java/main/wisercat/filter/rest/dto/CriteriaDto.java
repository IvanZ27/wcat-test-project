package main.wisercat.filter.rest.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CriteriaDto {

    private Integer id;
    private String criteriaText;
}
