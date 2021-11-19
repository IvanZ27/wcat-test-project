package main.wisercat.filter.persistance.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Filter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "filter_name")
    private String filterName;

    @Column(name = "criteria_id")
    private Integer criteriaId;

    @Column(name = "condition_id")
    private Integer conditionId;

    @Column(name = "amount_value")
    private Integer amountValue;

    @Column(name = "title_value")
    private String titleValue;

    @Column(name = "date_value")
    private LocalDate dateValue;

    @Column(name = "selection")
    private Integer selection;

}

