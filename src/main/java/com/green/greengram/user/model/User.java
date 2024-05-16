package com.green.greengram.user.model;

import lombok.Builder;
import lombok.Data;

@Data
public class User {
    private long userId;
    private String uid;
    private String upw;
    private String nm;
    private String pic;
    private String createdAt;
    private String updatedAt;
}
