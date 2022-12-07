package com.mizaela.LabShoppingList.domain.category;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "categories", uniqueConstraints =
        @UniqueConstraint(columnNames = {"name"}))
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
}
