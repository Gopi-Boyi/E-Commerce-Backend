package com.E.Commerce.Backend.Mapper;

import com.E.Commerce.Backend.Dto.CommentsDto;
import com.E.Commerce.Backend.Model.Comments;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentsMapper
{
    // toDto: Comments (Entity) → CommentsDto
    @Mapping(target = "userid", source = "user.id")
    CommentsDto toDto(Comments comments);

    // toEntity: CommentsDto → Comments (Entity)
    @Mapping(target = "user.id", source = "userid")
    @Mapping(target = "product", ignore = true)
    Comments toEntity(CommentsDto commentsDto);
}
