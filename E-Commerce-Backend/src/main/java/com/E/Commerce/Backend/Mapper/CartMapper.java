package com.E.Commerce.Backend.Mapper;

import com.E.Commerce.Backend.Dto.CartDto;
import com.E.Commerce.Backend.Dto.CartItemDto;
import com.E.Commerce.Backend.Model.Cart;
import com.E.Commerce.Backend.Model.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface CartMapper
{
    @Mapping(target = "userid" , source = "user.id")
    CartDto toDto(Cart cart);

    @Mapping(target = "user.id", source = "userid")
    Cart toEntity(CartDto cartDto);

    @Mapping(target = "productid" , source = "product.id")
    CartItemDto toDto(CartItem cartItem);

    @Mapping(target = "product.id", source = "productid")
    CartItem toEntity(CartItemDto cartItemDto);
}
