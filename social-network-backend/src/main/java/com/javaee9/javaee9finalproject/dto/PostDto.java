package com.javaee9.javaee9finalproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public record PostDto(Long id, //json will have the same keys with the values
                      String header,
                      @NotEmpty
                      @Size(min = 3, message = "Your post is too short :)")
                      String content,
                      @Size(min = 3, message = "Author name is too short :)")
                      @NotEmpty
                      String author,
                      @JsonProperty("creation_timestamp") //
                      String creationTimestamp,
                      @JsonProperty("update_timestamp")
                      String updateTimestamp) {
}
