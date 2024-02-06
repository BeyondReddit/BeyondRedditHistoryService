package com.example.beyondreddithistoryservice.dao;

import com.example.beyondreddithistoryservice.domain.entity.History;
import com.example.beyondreddithistoryservice.domain.response.HistoryResponse;
import com.example.beyondreddithistoryservice.service.remote.PostService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Repository
public class HistoryDao {

    @Autowired
    SessionFactory sessionFactory;

    private PostService postService;
    @Autowired
    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    public List<HistoryResponse> getAllHistorys(int userId,String authorizationHeader){
        Session session;
        List<HistoryResponse> historys = new ArrayList<>();
        try{
            session = sessionFactory.getCurrentSession();
            String sql;
            int user_id=1;
            sql = "select history.postId,history.viewDate from History history where history.userId  = :id";

            Query query = session.createQuery(sql);
            query.setParameter("id", userId);
            List<Object> resultList =query.list();
            List<String> viewdate = new ArrayList<>();
            List<String> titles = new ArrayList<>();
            String[] temp  = {"65c19e178f0b6c11c9bc1099", "65c198ba70823d3e2fea0bfb", "61b942a0f7d1c90001cd8d4e"};

            for (int i = 0; i < resultList.size(); i++) {
                Object[] obj = (Object[])resultList.get(i);
                viewdate.add((String)obj[1]);
                String postId= (String)obj[0];
                Object userPost= postService.getPostById(postId,authorizationHeader).getBody().getData();
                String postData = userPost.toString();
                String title = postData.substring(postData.indexOf("title=")+6,postData.indexOf(", content="));

               // titles.add("tile"+i);
                historys.add(new HistoryResponse(title,viewdate.get(i),postId));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return historys;
    }

    public String addPostHistory(String postid,int  userId){
        Session session;
        String message ="" ;
        int user_id=1;
        try{
            session = sessionFactory.getCurrentSession();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date date = new Date();
            String viewDate = df.format(date);
            History history = new History( userId,postid,viewDate);
            session.save(history);
            message = " New history has been added";
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return  message;
    }

    public List<HistoryResponse> getBySpecficDate(String viewDate,int userId,String authorizationHeader){
        Session session;
        List<HistoryResponse> historys = new ArrayList<>();
        try{
            session = sessionFactory.getCurrentSession();
            String sql;
            int user_id=1;
            sql = "select history.postId,history.viewDate from History history where history.userId  = :id and history.viewDate LIKE :specficdate ";
            Query query = session.createQuery(sql);
            query.setParameter("id", userId);
            query.setParameter("specficdate", viewDate+'%');
            List<Object> resultList =query.list();
            List<String> viewdate = new ArrayList<>();
           // List<String> title = new ArrayList<>();
            for (int i = 0; i < resultList.size(); i++) {
                Object[] obj = (Object[])resultList.get(i);
                viewdate.add((String)obj[1]);
                String postId= (String)obj[0];
                Object userPost= postService.getPostById(postId,authorizationHeader).getBody().getData();
                String postData = userPost.toString();
                String title = postData.substring(postData.indexOf("title=")+6,postData.indexOf(", content="));
               // title.add("tile"+i);
                historys.add(new HistoryResponse(title,viewdate.get(i),postId));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return historys;
    }


}
