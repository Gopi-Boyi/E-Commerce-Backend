package com.E.Commerce.Backend.Dto;

import lombok.Data;

import java.util.List;

@Data
public class CartDto
{
    private Long id;
    private Long userid;// userId
    private List<CartItemDto> items;
}
