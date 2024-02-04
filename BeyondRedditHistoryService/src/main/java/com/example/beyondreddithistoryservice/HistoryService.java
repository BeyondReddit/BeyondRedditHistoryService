package com.example.beyondreddithistoryservice;
import com.example.beyondreddithistoryservice.dao.HistoryDao;
import com.example.beyondreddithistoryservice.domain.response.HistoryResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HistoryService {
    private final HistoryDao historyDao;

    public HistoryService(HistoryDao historyDao) {
        this.historyDao = historyDao;
    }

    public List<HistoryResponse> getAllHistorys()
    {
        System.out.println("test");
        return  historyDao.getAllHistorys();
    }

    public String addPostHistory(int postid){
        return  historyDao.addPostHistory(postid);
    }

    public List<HistoryResponse> getBySpecficDate(String viewDate){
        return  historyDao.getBySpecficDate(viewDate);
    }


}
