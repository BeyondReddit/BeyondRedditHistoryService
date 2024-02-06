package com.example.beyondreddithistoryservice.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class UserInfo {
    private int userId;
    // private List<String> authorities;
    private String authorities;
}
