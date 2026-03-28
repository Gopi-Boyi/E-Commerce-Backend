package com.E.Commerce.Backend.Mapper;

import com.E.Commerce.Backend.Dto.CartDto;
import com.E.Commerce.Backend.Dto.CartItemDto;
import com.E.Commerce.Backend.Model.Cart;
import com.E.Commerce.Backend.Model.CartItem;
import com.E.Commerce.Backend.Model.Product;
import com.E.Commerce.Backend.Model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-28T13:37:42+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 25.0.1 (Oracle Corporation)"
)
@Component
public class CartMapperImpl implements CartMapper {

    @Override
    public CartDto toDto(Cart cart) {
        if ( cart == null ) {
            return null;
        }

        CartDto cartDto = new CartDto();

        cartDto.setUserid( cartUserId( cart ) );
        cartDto.setId( cart.getId() );
        cartDto.setItems( cartItemListToCartItemDtoList( cart.getItems() ) );

        return cartDto;
    }

    @Override
    public Cart toEntity(CartDto cartDto) {
        if ( cartDto == null ) {
            return null;
        }

        Cart cart = new Cart();

        cart.setUser( cartDtoToUser( cartDto ) );
        cart.setId( cartDto.getId() );
        cart.setItems( cartItemDtoListToCartItemList( cartDto.getItems() ) );

        return cart;
    }

    @Override
    public CartItemDto toDto(CartItem cartItem) {
        if ( cartItem == null ) {
            return null;
        }

        CartItemDto cartItemDto = new CartItemDto();

        cartItemDto.setProductid( cartItemProductId( cartItem ) );
        cartItemDto.setId( cartItem.getId() );
        cartItemDto.setQuantity( cartItem.getQuantity() );

        return cartItemDto;
    }

    @Override
    public CartItem toEntity(CartItemDto cartItemDto) {
        if ( cartItemDto == null ) {
            return null;
        }

        CartItem cartItem = new CartItem();

        cartItem.setProduct( cartItemDtoToProduct( cartItemDto ) );
        cartItem.setId( cartItemDto.getId() );
        cartItem.setQuantity( cartItemDto.getQuantity() );

        return cartItem;
    }

    private Long cartUserId(Cart cart) {
        if ( cart == null ) {
            return null;
        }
        User user = cart.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected List<CartItemDto> cartItemListToCartItemDtoList(List<CartItem> list) {
        if ( list == null ) {
            return null;
        }

        List<CartItemDto> list1 = new ArrayList<CartItemDto>( list.size() );
        for ( CartItem cartItem : list ) {
            list1.add( toDto( cartItem ) );
        }

        return list1;
    }

    protected User cartDtoToUser(CartDto cartDto) {
        if ( cartDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( cartDto.getUserid() );

        return user;
    }

    protected List<CartItem> cartItemDtoListToCartItemList(List<CartItemDto> list) {
        if ( list == null ) {
            return null;
        }

        List<CartItem> list1 = new ArrayList<CartItem>( list.size() );
        for ( CartItemDto cartItemDto : list ) {
            list1.add( toEntity( cartItemDto ) );
        }

        return list1;
    }

    private Long cartItemProductId(CartItem cartItem) {
        if ( cartItem == null ) {
            return null;
        }
        Product product = cartItem.getProduct();
        if ( product == null ) {
            return null;
        }
        Long id = product.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Product cartItemDtoToProduct(CartItemDto cartItemDto) {
        if ( cartItemDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( cartItemDto.getProductid() );

        return product;
    }
}
