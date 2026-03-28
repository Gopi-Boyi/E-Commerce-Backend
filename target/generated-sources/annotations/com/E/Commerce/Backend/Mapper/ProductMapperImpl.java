package com.E.Commerce.Backend.Mapper;

import com.E.Commerce.Backend.Dto.CommentsDto;
import com.E.Commerce.Backend.Dto.ProductDto;
import com.E.Commerce.Backend.Model.Comments;
import com.E.Commerce.Backend.Model.Product;
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
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto toDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setImage( product.getImage() );
        productDto.setId( product.getId() );
        productDto.setName( product.getName() );
        productDto.setDescription( product.getDescription() );
        productDto.setPrice( product.getPrice() );
        productDto.setQuantity( product.getQuantity() );
        productDto.setComments( commentsListToCommentsDtoList( product.getComments() ) );

        return productDto;
    }

    @Override
    public Product toEntity(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setImage( productDto.getImage() );
        product.setId( productDto.getId() );
        product.setName( productDto.getName() );
        product.setDescription( productDto.getDescription() );
        product.setPrice( productDto.getPrice() );
        product.setQuantity( productDto.getQuantity() );
        product.setComments( commentsDtoListToCommentsList( productDto.getComments() ) );

        return product;
    }

    protected CommentsDto commentsToCommentsDto(Comments comments) {
        if ( comments == null ) {
            return null;
        }

        CommentsDto commentsDto = new CommentsDto();

        commentsDto.setId( comments.getId() );
        commentsDto.setContent( comments.getContent() );
        commentsDto.setScore( comments.getScore() );

        return commentsDto;
    }

    protected List<CommentsDto> commentsListToCommentsDtoList(List<Comments> list) {
        if ( list == null ) {
            return null;
        }

        List<CommentsDto> list1 = new ArrayList<CommentsDto>( list.size() );
        for ( Comments comments : list ) {
            list1.add( commentsToCommentsDto( comments ) );
        }

        return list1;
    }

    protected Comments commentsDtoToComments(CommentsDto commentsDto) {
        if ( commentsDto == null ) {
            return null;
        }

        Comments comments = new Comments();

        comments.setId( commentsDto.getId() );
        comments.setContent( commentsDto.getContent() );
        comments.setScore( commentsDto.getScore() );

        return comments;
    }

    protected List<Comments> commentsDtoListToCommentsList(List<CommentsDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Comments> list1 = new ArrayList<Comments>( list.size() );
        for ( CommentsDto commentsDto : list ) {
            list1.add( commentsDtoToComments( commentsDto ) );
        }

        return list1;
    }
}
