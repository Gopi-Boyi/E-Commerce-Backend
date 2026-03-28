package com.E.Commerce.Backend.Mapper;

import com.E.Commerce.Backend.Dto.OrderDto;
import com.E.Commerce.Backend.Dto.OrderItemDto;
import com.E.Commerce.Backend.Model.Order;
import com.E.Commerce.Backend.Model.OrderItem;
import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface OrderMapper
{
    @Mapping(target = "userId" , source = "user.id")
    @Mapping(target = "orderItems", source = "items")
    OrderDto toDto(Order order);

    @Mapping(target = "user.id" , source = "userId")
    @Mapping(target = "items" , source = "orderItems")
    Order toEntity(OrderDto orderDto);

    List<OrderDto> toDto(List<Order> orders);

    List<Order> toEntity(List<OrderDto> orderDtos);

    @Mapping(target = "productId" , source = "product.id")
    OrderItemDto toOrderItemDto(OrderItem orderItem);

    @Mapping(target = "product.id" , source = "productId")
    OrderItem toOrderItem(OrderItemDto orderItemDto);

    List<OrderItemDto> toOrderItemDtos (List<OrderItem> orderItems);

    List<OrderItem> toOrderItemEntities(List<OrderItemDto> orderItemDtos);
}
