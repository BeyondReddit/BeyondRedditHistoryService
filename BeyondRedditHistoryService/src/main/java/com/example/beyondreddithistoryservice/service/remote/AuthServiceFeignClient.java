package com.example.beyondreddithistoryservice.service.remote;


import com.example.beyondreddithistoryservice.domain.entity.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Optional;

@FeignClient(name = "authentication-service")
public interface AuthServiceFeignClient {
    @GetMapping("auth/getCurrentUser")
    Optional<UserInfo> getCurrentUser(@RequestHeader("Authorization") String token);
}
