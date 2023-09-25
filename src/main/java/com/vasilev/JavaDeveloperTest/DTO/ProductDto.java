package com.vasilev.JavaDeveloperTest.DTO;

import jakarta.validation.constraints.NotNull;

public class ProductDto {

    @NotNull
    private Integer code;

    @NotNull
    private String category;

    @NotNull
    private String brand;

}
