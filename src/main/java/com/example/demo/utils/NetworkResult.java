package com.example.demo.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Setter
public class NetworkResult<T> {
    @JsonProperty
    private int responseCode;

    @JsonProperty
    private String responseMessage;

    @JsonProperty
    @Nullable
    private T data;
}
