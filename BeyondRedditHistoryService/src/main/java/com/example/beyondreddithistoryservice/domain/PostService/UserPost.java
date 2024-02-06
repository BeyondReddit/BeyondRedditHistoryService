package com.example.beyondreddithistoryservice.domain.PostService;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
//import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.mongodb.core.mapping.DocumentReference;
//import org.springframework.data.mongodb.core.mapping.Field;
//import org.springframework.data.mongodb.core.mapping.FieldType;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

//@Document(collection="posts")
@Data
@Builder
public class UserPost {

    private ObjectId id;
    //    private String postId;
    private Long userId;
    private String title;
    private String content;
    private boolean isArchived;
    private PostState status;
    private Date dateCreated;
    private Date dateModified;
    private List<String> images;
    private List<String> attachments;
    private List<PostReply> postReplies;

}
