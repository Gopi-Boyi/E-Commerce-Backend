package com.E.Commerce.Backend.Service;

import com.E.Commerce.Backend.Dto.CartDto;
import com.E.Commerce.Backend.Exception.InsufficientStockException;
import com.E.Commerce.Backend.Exception.ResourceNotFoundException;
import com.E.Commerce.Backend.Mapper.CartMapper;
import com.E.Commerce.Backend.Model.Cart;
import com.E.Commerce.Backend.Model.CartItem;
import com.E.Commerce.Backend.Model.Product;
import com.E.Commerce.Backend.Model.User;
import com.E.Commerce.Backend.Repositories.CartRepository;
import com.E.Commerce.Backend.Repositories.ProductRepository;
import com.E.Commerce.Backend.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService
{
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CartMapper cartMapper;

    //Add items TO the Cart
    public CartDto addToCart(Long userId, Long productId, Integer quantity){
        User user=userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User Not Found"));
        Product product=productRepository.findById(productId)
                .orElseThrow(()->new ResourceNotFoundException("Product Not Found"));
        if(product.getQuantity()<quantity){
            throw new InsufficientStockException("Not enough available");
        }
        Cart cart=cartRepository.findByUserId(userId)
                .orElse(new Cart(null, user, new ArrayList<>()));
        Optional<CartItem> existingCartItem=cart.getItems().stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst();
        if(existingCartItem.isPresent()){
            CartItem cartItem=existingCartItem.get();
            cartItem.setQuantity(cartItem.getQuantity()+quantity);
        }else {
            CartItem cartItem=new CartItem(null, cart, product, quantity);
            cart.getItems().add(cartItem);
        }
        Cart savedCart = cartRepository.save(cart);
        return cartMapper.toDto(savedCart);
    }
    //To check the Cart Items
    public CartDto getCart(Long userId){
        Cart cart=cartRepository.findByUserId(userId)
                .orElseThrow(()->new ResourceNotFoundException("Cart Not Found"));
        return cartMapper.toDto(cart);
    }
    //To clear the Cart
    public void clearCart(Long userId){
        Cart cart=cartRepository.findByUserId(userId)
                .orElseThrow(()->new ResourceNotFoundException("Cart Not Found"));
        cart.getItems().clear();
        cartRepository.save(cart);
    }
}
