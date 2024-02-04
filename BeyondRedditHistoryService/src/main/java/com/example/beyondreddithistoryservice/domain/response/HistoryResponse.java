package com.example.beyondreddithistoryservice.domain.response;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HistoryResponse {
    private String posttitle;
    private String viewdate;
}
