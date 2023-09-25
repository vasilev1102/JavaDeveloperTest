package com.vasilev.JavaDeveloperTest.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "Product")
@Data
public class Product {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "code")
    private Integer code;

    @NotNull
    @Column(name = "category")
    private String category;

    @NotNull
    @Column(name = "brand")
    private String brand;



}
