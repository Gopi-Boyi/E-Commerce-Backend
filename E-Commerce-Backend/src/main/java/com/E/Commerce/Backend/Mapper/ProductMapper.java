package com.E.Commerce.Backend.Mapper;

import com.E.Commerce.Backend.Dto.CommentsDto;
import com.E.Commerce.Backend.Dto.ProductDto;
import com.E.Commerce.Backend.Model.Comments;
import com.E.Commerce.Backend.Model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
public interface ProductMapper
{
    @Mapping(target = "image", source = "image") //add mapping
    ProductDto toDto(Product product);

    @Mapping(target = "image", source = "image") // add mapping
    Product toEntity(ProductDto productDto);




}
