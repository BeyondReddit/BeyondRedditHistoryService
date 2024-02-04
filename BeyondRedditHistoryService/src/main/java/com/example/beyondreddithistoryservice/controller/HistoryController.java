package com.example.beyondreddithistoryservice.controller;
import com.example.beyondreddithistoryservice.HistoryService;
import com.example.beyondreddithistoryservice.domain.response.Hintmessage;
import com.example.beyondreddithistoryservice.domain.response.HistoryResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("history-service")
public class HistoryController {
    private final HistoryService historyService;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping(("/all"))
    public List<HistoryResponse> getAllHistorys() {

        return historyService.getAllHistorys();
    }

    @PostMapping (("/post/{id}"))
    public Hintmessage createHistory(@PathVariable int id) {
        String message = historyService.addPostHistory(id);
        return Hintmessage.builder()
                .message(message)
                .build();

    }

    @GetMapping(("/date/{specificdate}"))
    public List<HistoryResponse> getBySpecificdate(@PathVariable String specificdate) {

        return historyService.getBySpecficDate(specificdate);
    }

}
