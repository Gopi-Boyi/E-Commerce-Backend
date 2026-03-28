package com.E.Commerce.Backend.Mapper;

import com.E.Commerce.Backend.Dto.CommentsDto;
import com.E.Commerce.Backend.Model.Comments;
import com.E.Commerce.Backend.Model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-28T13:37:42+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 25.0.1 (Oracle Corporation)"
)
@Component
public class CommentsMapperImpl implements CommentsMapper {

    @Override
    public CommentsDto toDto(Comments comments) {
        if ( comments == null ) {
            return null;
        }

        CommentsDto commentsDto = new CommentsDto();

        commentsDto.setUserid( commentsUserId( comments ) );
        commentsDto.setId( comments.getId() );
        commentsDto.setContent( comments.getContent() );
        commentsDto.setScore( comments.getScore() );

        return commentsDto;
    }

    @Override
    public Comments toEntity(CommentsDto commentsDto) {
        if ( commentsDto == null ) {
            return null;
        }

        Comments comments = new Comments();

        comments.setUser( commentsDtoToUser( commentsDto ) );
        comments.setId( commentsDto.getId() );
        comments.setContent( commentsDto.getContent() );
        comments.setScore( commentsDto.getScore() );

        return comments;
    }

    private Long commentsUserId(Comments comments) {
        if ( comments == null ) {
            return null;
        }
        User user = comments.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected User commentsDtoToUser(CommentsDto commentsDto) {
        if ( commentsDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( commentsDto.getUserid() );

        return user;
    }
}
