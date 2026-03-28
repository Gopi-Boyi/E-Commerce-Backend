package com.E.Commerce.Backend.Repositories;

import com.E.Commerce.Backend.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>
{
    List<Order> findByUserId(Long userId);
}
