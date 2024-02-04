package com.example.beyondreddithistoryservice.dao;

import com.example.beyondreddithistoryservice.domain.entity.History;
import com.example.beyondreddithistoryservice.domain.response.HistoryResponse;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<HistoryResponse> getAllHistorys(){
        Session session;
        List<HistoryResponse> historys = new ArrayList<>();
        try{
            session = sessionFactory.getCurrentSession();
            String sql;
            int user_id=1;


            sql = "select history.postId,history.viewDate from History history where history.userId  = :id";

            Query query = session.createQuery(sql);
            query.setParameter("id", user_id);
            List<Object> resultList =query.list();
            List<String> viewdate = new ArrayList<>();
            List<String> title = new ArrayList<>();
            for (int i = 0; i < resultList.size(); i++) {
                Object[] obj = (Object[])resultList.get(i);
                viewdate.add((String)obj[1]);
                title.add("tile"+i);
                historys.add(new HistoryResponse(title.get(i),viewdate.get(i)));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return historys;
    }

    public String addPostHistory(int postid){
        Session session;
        String message ="" ;
        int userId =1;
        try{
            session = sessionFactory.getCurrentSession();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date date = new Date();
            String viewDate = df.format(date);
            History history = new History(userId,postid,viewDate);
            session.save(history);
            message = " New history has been added";

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return  message;
    }

    public List<HistoryResponse> getBySpecficDate(String viewDate){
        Session session;
        List<HistoryResponse> historys = new ArrayList<>();
        try{
            session = sessionFactory.getCurrentSession();
            String sql;
            int user_id=1;


            sql = "select history.postId,history.viewDate from History history where history.userId  = :id and history.viewDate LIKE :specficdate ";

            Query query = session.createQuery(sql);
            query.setParameter("id", user_id);
            query.setParameter("specficdate", viewDate+'%');
            List<Object> resultList =query.list();
            List<String> viewdate = new ArrayList<>();
            List<String> title = new ArrayList<>();
            for (int i = 0; i < resultList.size(); i++) {
                Object[] obj = (Object[])resultList.get(i);
                viewdate.add((String)obj[1]);
                title.add("tile"+i);
                historys.add(new HistoryResponse(title.get(i),viewdate.get(i)));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return historys;
    }


}
