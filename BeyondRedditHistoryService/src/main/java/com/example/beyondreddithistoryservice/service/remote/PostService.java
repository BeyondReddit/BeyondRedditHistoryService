package com.example.beyondreddithistoryservice.service.remote;
import com.example.beyondreddithistoryservice.domain.PostService.UserPost;
import com.example.beyondreddithistoryservice.domain.response.DataResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient("post-service")
public interface PostService {
    @GetMapping("posts/all")
    ResponseEntity<DataResponse> getAllPosts(@RequestHeader("Authorization") String authorizationHeader);
   // @RequestParam String postId

     @GetMapping("posts")
     ResponseEntity<DataResponse> getPostById(@RequestParam String postId,@RequestHeader("Authorization") String authorizationHeader);

}

