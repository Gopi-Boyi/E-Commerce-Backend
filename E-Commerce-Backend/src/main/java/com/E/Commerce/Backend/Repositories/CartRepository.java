package com.E.Commerce.Backend.Repositories;

import com.E.Commerce.Backend.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart , Long>
{
    Optional<Cart> findByUserId(Long userId);
}
