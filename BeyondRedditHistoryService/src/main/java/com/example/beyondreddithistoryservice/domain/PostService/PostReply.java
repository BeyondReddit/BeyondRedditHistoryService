package com.example.beyondreddithistoryservice.domain.PostService;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
//import org.springframework.data.mongodb.core.mapping.Field;
//import org.springframework.data.mongodb.core.mapping.FieldType;
//
//import javax.persistence.Id;
import java.util.Date;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;


import javax.persistence.Id;
import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostReply {
    private ObjectId id;
    private long userId;
    private String comment;
    private boolean isActive;
    private Date dateCreated;
    private List<SubReply> subReplies;
}