package com.E.Commerce.Backend.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ProductListDto
{
    private Long id;
    @NotBlank(message = "Name must be required")
    private String name;
    @NotBlank(message = "Description must be required")
    private String description;
    @Positive(message = "Price must be positive")
    private BigDecimal price;
    @PositiveOrZero(message = "Quantity must be positive or zero")
    private Integer quantity;
    @NotBlank
    private String image;
}
