package com.example.beyondreddithistoryservice.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "historyId", unique = true, nullable = false)
    private Integer historyId;

    @Column(name = "userId")
    private int userId;

    @Column(name = "postId")
    private int postId;

    @Column(name = "viewDate")
    private String viewDate ;

    public History(int userId,int postId, String viewDate){
        this.userId = userId;
        this.postId = postId;
        this.viewDate = viewDate;
    }

}
