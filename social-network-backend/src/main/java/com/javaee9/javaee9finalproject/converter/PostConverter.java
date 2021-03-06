package com.javaee9.javaee9finalproject.converter;

import com.javaee9.javaee9finalproject.dto.PostDto;
import com.javaee9.javaee9finalproject.entity.Post;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
public class PostConverter implements Converter<PostDto, Post> {
    @Override
    public Post fromDtoToEntity(PostDto postDto) {
        return Post.builder()
                .id(postDto.id())
                .header(postDto.header())
                .content(postDto.content())
                .author(postDto.author())
                .creationTimestamp(fromString(postDto.creationTimestamp()))
                .updateTimestamp(fromString(postDto.updateTimestamp()))
                .build();
    }

    @Override
    public PostDto fromEntityToDto(Post post) {
        return new PostDto(post.getId(),
                post.getHeader(),
                post.getContent(),
                post.getAuthor(),
                post.getCreationTimestamp().toString(), //on tdo side its string, therefor we  need to convert it
                post.getUpdateTimestamp().toString());
    }

    private ZonedDateTime fromString(String timestamp) {
        return timestamp != null ? ZonedDateTime.parse(timestamp) : null;
    }
}
