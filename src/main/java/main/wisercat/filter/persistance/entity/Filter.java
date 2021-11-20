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

    @ManyToOne
    @JoinColumn(name = "criteria_id", referencedColumnName = "id")
    private Criteria criteria;

    @ManyToOne
    @JoinColumn(name = "condition_id", referencedColumnName = "id")
    private Condition condition;

    @Column(name = "amount_value")
    private Integer amountValue;

    @Column(name = "title_value")
    private String titleValue;

    @Column(name = "date_value")
    private LocalDate dateValue;

    @Column(name = "selection")
    private Integer selection;

}

