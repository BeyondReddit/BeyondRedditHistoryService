package com.example.beyondreddithistoryservice.domain.response;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class DataResponse {
    private Boolean success;
    private String message;
    private Object data;
}
