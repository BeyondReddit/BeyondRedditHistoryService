package com.example.beyondreddithistoryservice.service;

import com.example.beyondreddithistoryservice.dao.HistoryDao;
import com.example.beyondreddithistoryservice.domain.PostService.UserPost;
import com.example.beyondreddithistoryservice.domain.response.HistoryResponse;
import com.example.beyondreddithistoryservice.service.remote.PostService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
@Service
@Transactional
public class HistoryService {
    private final HistoryDao historyDao;
    private PostService postService;
    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public HistoryService(HistoryDao historyDao) {
        this.historyDao = historyDao;
    }
    @Autowired
    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    public List<HistoryResponse> getAllHistorys(int userId,String authorizationHeader) {
//        Object userPost= postService.getPostById("65c19e178f0b6c11c9bc1099").getBody().getData();
//        String postData = userPost.toString();
//        String title = postData.substring(postData.indexOf("title=")+6,postData.indexOf(", content="));
//        System.out.println("title:"+ postData.substring(postData.indexOf("title=")+6,postData.indexOf(", content=")));
//      ObjectMapper mapper = new ObjectMapper();
//      UserPost asArray = mapper.readValue( userPost.toString(), UserPost.class);
//        ResponseEntity<DataResponse> postResponse =restTemplate.exchange(
//                                "http://post-service/posts/all", HttpMethod.GET, null, DataResponse.class
//                       );

        return historyDao.getAllHistorys(userId,authorizationHeader);
    }

    public String addPostHistory(String postid,int userId) {
        return historyDao.addPostHistory(postid, userId);
    }

    public List<HistoryResponse> getBySpecficDate(String viewDate,int userId,String authorizationHeader){
        return  historyDao.getBySpecficDate(viewDate,userId,authorizationHeader);
    }
}