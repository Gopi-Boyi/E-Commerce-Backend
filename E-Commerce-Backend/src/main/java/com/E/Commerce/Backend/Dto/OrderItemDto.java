package com.E.Commerce.Backend.Dto;

import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDto
{
    private Long id;
    private Long productId;
    private Long productItem;
    @Positive
    private Integer quantity;
    @Positive
    private BigDecimal price;
}
