package com.E.Commerce.Backend.Dto;

import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CartItemDto
{
    private Long id;
    private Long productid;
    @Positive
    private Integer quantity;
}
