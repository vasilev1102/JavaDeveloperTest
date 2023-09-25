package com.vasilev.JavaDeveloperTest.DTO;

import com.vasilev.JavaDeveloperTest.Entity.Customer;
import com.vasilev.JavaDeveloperTest.Entity.Product;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

public class ShipmentDto {
    @NotNull
    private List<Product> products;

    @NotNull
    private Customer customer;

    @NotNull
    private OffsetDateTime date;

    @NotNull
    private String shipmentName;

    @NotNull
    private boolean promo;

    /**
     * В задании этого поля нет, но я не понял как еще считать количество товаров на одну отгрузку
     */
    @NotNull
    private Long count;

    @NotNull
    @Column(name = "all_price")
    private BigDecimal price;
}
