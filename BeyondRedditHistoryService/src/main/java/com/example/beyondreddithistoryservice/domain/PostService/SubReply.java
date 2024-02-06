package com.example.beyondreddithistoryservice.domain.PostService;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;

import javax.persistence.Id;
import java.util.Date;

@Data
@Builder
public class SubReply {
    private ObjectId id;
    private long userId;
    private String comment;
    private boolean isActive;
    private Date dateCreated;
}
