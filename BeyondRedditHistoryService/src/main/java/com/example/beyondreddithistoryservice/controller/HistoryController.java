package com.example.beyondreddithistoryservice.controller;

import com.example.beyondreddithistoryservice.domain.entity.UserInfo;
import com.example.beyondreddithistoryservice.domain.response.Hintmessage;
import com.example.beyondreddithistoryservice.domain.response.HistoryResponse;
import com.example.beyondreddithistoryservice.service.HistoryService;
import com.example.beyondreddithistoryservice.service.remote.AuthServiceFeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://127.0.0.1:5173")
@RestController
@RequestMapping("history-service")
public class HistoryController {
    private final HistoryService historyService;
    private final AuthServiceFeignClient authServiceFeignClient;

    public HistoryController(HistoryService historyService, AuthServiceFeignClient authServiceFeignClient) {
        this.historyService = historyService;
        this.authServiceFeignClient = authServiceFeignClient;
    }

    @GetMapping(("/all"))
    public List<HistoryResponse> getAllHistorys(@RequestHeader("Authorization") String authorizationHeader)  {

        UserInfo userInfo = authServiceFeignClient.getCurrentUser(authorizationHeader).orElse(null);
        int userId = userInfo.getUserId();
        System.out.println("userid=" + userId);
        return historyService.getAllHistorys(userId,authorizationHeader);
    }

    @PostMapping (("/post/{id}"))
    public Hintmessage createHistory(@RequestHeader("Authorization") String authorizationHeader,@PathVariable String id) {
        UserInfo userInfo = authServiceFeignClient.getCurrentUser(authorizationHeader).orElse(null);
        int userId = userInfo.getUserId();
        String message = historyService.addPostHistory(id,userId);
        return Hintmessage.builder()
                .message(message)
                .build();

    }

    @GetMapping(("/date/{specificdate}"))
    public List<HistoryResponse> getBySpecificdate(@RequestHeader("Authorization") String authorizationHeader,@PathVariable String specificdate) {
        UserInfo userInfo = authServiceFeignClient.getCurrentUser(authorizationHeader).orElse(null);
        int userId = userInfo.getUserId();
        return historyService.getBySpecficDate(specificdate,userId,authorizationHeader);
    }

}
