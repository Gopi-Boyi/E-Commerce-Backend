package com.E.Commerce.Backend.Service;

import com.E.Commerce.Backend.Dto.CommentsDto;
import com.E.Commerce.Backend.Exception.ResourceNotFoundException;
import com.E.Commerce.Backend.Mapper.CommentsMapper;
import com.E.Commerce.Backend.Model.Comments;
import com.E.Commerce.Backend.Model.Product;
import com.E.Commerce.Backend.Model.User;
import com.E.Commerce.Backend.Repositories.CommentsRepository;
import com.E.Commerce.Backend.Repositories.ProductRepository;
import com.E.Commerce.Backend.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentsService
{
    private final CommentsRepository commentsRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CommentsMapper commentsMapper;



    public CommentsDto addComments(Long productId, Long userId, CommentsDto commentsDto){
        Product product=productRepository.findById(productId)
                .orElseThrow(()-> new ResourceNotFoundException("Product Not Found"));
        User user=userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User not found"));
        Comments comments=commentsMapper.toEntity(commentsDto);
        comments.setProduct(product);
        comments.setUser(user);
        Comments savedComments =commentsRepository.save(comments);
        return commentsMapper.toDto(savedComments);

    }
    public List<CommentsDto> getCommentsByProducts(Long productId){
        List<Comments> comments=commentsRepository.findByProductId(productId);
        return comments.stream()
                .map(commentsMapper::toDto)
                .collect(Collectors.toList());
    }

}
