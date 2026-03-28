package com.E.Commerce.Backend.Controller;

import com.E.Commerce.Backend.Dto.OrderDto;
import com.E.Commerce.Backend.Model.Order;
import com.E.Commerce.Backend.Model.User;
import com.E.Commerce.Backend.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController
{
    private final OrderService orderService;

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<OrderDto> createOrder(@AuthenticationPrincipal UserDetails userDetails,
                                                @RequestParam String address,
                                                @RequestParam String phoneNumber){
    Long userId=((User) userDetails).getId();
    OrderDto orderDto=orderService.createOrder(userId,address,phoneNumber);
    return ResponseEntity.ok(orderDto);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<OrderDto>> getAllOrders(){
        List<OrderDto> orders=orderService.getAllOrder();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/user")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<OrderDto>> getUserOrders(@AuthenticationPrincipal UserDetails userDetails){
        Long userId=((User) userDetails).getId();
        List<OrderDto> orders=orderService.getUserOrder(userId);
        return ResponseEntity.ok(orders);
    }

    @PutMapping("/{orderId}/status")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<OrderDto> updateOrderStatus(@PathVariable Long orderId,
                                                            @RequestParam Order.OrderStatus status){
       OrderDto updatedOrder=orderService.updateOrderStatus(orderId,status);
        return ResponseEntity.ok(updatedOrder);
    }
}
