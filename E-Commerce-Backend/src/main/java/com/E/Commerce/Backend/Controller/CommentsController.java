package com.E.Commerce.Backend.Controller;

import com.E.Commerce.Backend.Dto.CommentsDto;
import com.E.Commerce.Backend.Model.User;
import com.E.Commerce.Backend.Repositories.UserRepository;
import com.E.Commerce.Backend.Service.CommentsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentsController
{
    private final CommentsService commentsService;
    private final UserRepository userRepository;


    @PostMapping("/product/{productId}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<CommentsDto> addProduct(@PathVariable Long productId,
                                                  @AuthenticationPrincipal UserDetails userDetails,
                                                  @Valid @RequestBody CommentsDto commentsDto){
        // cast userDetails to User, then call getId()
        Long userId = ((User) userDetails).getId();
        return ResponseEntity.ok(commentsService.addComments(productId, userId, commentsDto));
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<CommentsDto>> getCommentsByProducts(@PathVariable Long productId){
        return ResponseEntity.ok(commentsService.getCommentsByProducts(productId));
    }
}