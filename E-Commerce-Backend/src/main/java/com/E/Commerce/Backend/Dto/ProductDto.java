package com.E.Commerce.Backend.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductDto
{
    private Long id;

    @NotBlank(message = "product name must be required")
    private String name;

    @NotBlank(message = "product description must be required")
    private String description;

    @Positive(message = "cannot be negative")
    private BigDecimal price;

    @PositiveOrZero(message = "cannot be negative")
    private Integer quantity;
    private String image; //add image
    private List<CommentsDto> comments;
}
