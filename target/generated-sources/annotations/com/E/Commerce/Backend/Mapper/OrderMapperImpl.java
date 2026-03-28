package com.E.Commerce.Backend.Mapper;

import com.E.Commerce.Backend.Dto.OrderDto;
import com.E.Commerce.Backend.Dto.OrderItemDto;
import com.E.Commerce.Backend.Model.Order;
import com.E.Commerce.Backend.Model.OrderItem;
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
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderDto toDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDto orderDto = new OrderDto();

        orderDto.setUserId( orderUserId( order ) );
        orderDto.setOrderItems( toOrderItemDtos( order.getItems() ) );
        orderDto.setId( order.getId() );
        orderDto.setAddress( order.getAddress() );
        orderDto.setPhoneNumber( order.getPhoneNumber() );
        orderDto.setStatus( order.getStatus() );
        orderDto.setCreatedAt( order.getCreatedAt() );

        return orderDto;
    }

    @Override
    public Order toEntity(OrderDto orderDto) {
        if ( orderDto == null ) {
            return null;
        }

        Order order = new Order();

        order.setUser( orderDtoToUser( orderDto ) );
        order.setItems( toOrderItemEntities( orderDto.getOrderItems() ) );
        order.setId( orderDto.getId() );
        order.setAddress( orderDto.getAddress() );
        order.setPhoneNumber( orderDto.getPhoneNumber() );
        order.setStatus( orderDto.getStatus() );
        order.setCreatedAt( orderDto.getCreatedAt() );

        return order;
    }

    @Override
    public List<OrderDto> toDto(List<Order> orders) {
        if ( orders == null ) {
            return null;
        }

        List<OrderDto> list = new ArrayList<OrderDto>( orders.size() );
        for ( Order order : orders ) {
            list.add( toDto( order ) );
        }

        return list;
    }

    @Override
    public List<Order> toEntity(List<OrderDto> orderDtos) {
        if ( orderDtos == null ) {
            return null;
        }

        List<Order> list = new ArrayList<Order>( orderDtos.size() );
        for ( OrderDto orderDto : orderDtos ) {
            list.add( toEntity( orderDto ) );
        }

        return list;
    }

    @Override
    public OrderItemDto toOrderItemDto(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }

        OrderItemDto orderItemDto = new OrderItemDto();

        orderItemDto.setProductId( orderItemProductId( orderItem ) );
        orderItemDto.setId( orderItem.getId() );
        orderItemDto.setQuantity( orderItem.getQuantity() );
        orderItemDto.setPrice( orderItem.getPrice() );

        return orderItemDto;
    }

    @Override
    public OrderItem toOrderItem(OrderItemDto orderItemDto) {
        if ( orderItemDto == null ) {
            return null;
        }

        OrderItem orderItem = new OrderItem();

        orderItem.setProduct( orderItemDtoToProduct( orderItemDto ) );
        orderItem.setId( orderItemDto.getId() );
        orderItem.setQuantity( orderItemDto.getQuantity() );
        orderItem.setPrice( orderItemDto.getPrice() );

        return orderItem;
    }

    @Override
    public List<OrderItemDto> toOrderItemDtos(List<OrderItem> orderItems) {
        if ( orderItems == null ) {
            return null;
        }

        List<OrderItemDto> list = new ArrayList<OrderItemDto>( orderItems.size() );
        for ( OrderItem orderItem : orderItems ) {
            list.add( toOrderItemDto( orderItem ) );
        }

        return list;
    }

    @Override
    public List<OrderItem> toOrderItemEntities(List<OrderItemDto> orderItemDtos) {
        if ( orderItemDtos == null ) {
            return null;
        }

        List<OrderItem> list = new ArrayList<OrderItem>( orderItemDtos.size() );
        for ( OrderItemDto orderItemDto : orderItemDtos ) {
            list.add( toOrderItem( orderItemDto ) );
        }

        return list;
    }

    private Long orderUserId(Order order) {
        if ( order == null ) {
            return null;
        }
        User user = order.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected User orderDtoToUser(OrderDto orderDto) {
        if ( orderDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( orderDto.getUserId() );

        return user;
    }

    private Long orderItemProductId(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }
        Product product = orderItem.getProduct();
        if ( product == null ) {
            return null;
        }
        Long id = product.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Product orderItemDtoToProduct(OrderItemDto orderItemDto) {
        if ( orderItemDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( orderItemDto.getProductId() );

        return product;
    }
}
