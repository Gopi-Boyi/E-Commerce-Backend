package com.E.Commerce.Backend.Dto;

import java.time.LocalDateTime;
import java.util.List;

import com.E.Commerce.Backend.Model.Order;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OrderDto
{
    private Long id;
    private Long userId;
    @NotBlank(message = "Address must be required")
    private String address;
    @NotBlank(message = "PhoneNumber must be required")
    private String phoneNumber;
    private Order.OrderStatus  status;
    private LocalDateTime createdAt;
    private List<OrderItemDto> orderItems;


}
