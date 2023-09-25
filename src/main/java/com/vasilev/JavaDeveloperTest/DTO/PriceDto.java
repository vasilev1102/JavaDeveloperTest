package com.vasilev.JavaDeveloperTest.DTO;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class PriceDto {

    @NotNull
    public Long productId;

    @NotNull
    public Long customerId;

    @NotNull
    public BigDecimal price;
}
