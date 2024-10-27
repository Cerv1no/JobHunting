package com.Cerv1no.JobHunting.Job;

import com.Cerv1no.JobHunting.Company.Company;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private BigDecimal minSalary;
    private BigDecimal maxSalary;
    private String location;

    @ManyToOne
    private Company company;
}
