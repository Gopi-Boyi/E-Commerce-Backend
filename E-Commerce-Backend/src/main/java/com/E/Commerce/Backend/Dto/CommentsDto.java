package com.E.Commerce.Backend.Dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CommentsDto
{

        private Long id;

        @NotBlank(message = "Content must be required")
        private String content;
        @Min(value = 1)
        @Max(value = 5)
        private Integer score;
        private Long userid;

}
