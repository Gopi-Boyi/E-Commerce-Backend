package com.E.Commerce.Backend.Repositories;

import com.E.Commerce.Backend.Dto.ProductDto;
import com.E.Commerce.Backend.Dto.ProductListDto;
import com.E.Commerce.Backend.Model.Product;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>
{
    @Query("SELECT new com.E.Commerce.Backend.Dto.ProductListDto(p.id, p.name , p.description, " +
            "p.price, p.quantity, p.image) FROM Product p")
    List<ProductListDto> findAllWithoutComments();
}
