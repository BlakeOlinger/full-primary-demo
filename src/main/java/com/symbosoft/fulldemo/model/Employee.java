package com.symbosoft.fulldemo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Base entity template for generic'person'
 *
 * for template and testing purposes
 */

@Entity
@Table(name = "person")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 3, max = 20)
    private String name;
}
