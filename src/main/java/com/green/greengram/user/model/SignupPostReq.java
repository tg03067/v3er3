package com.green.greengram.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class SignupPostReq {
    @JsonIgnore
    private long userId;

    private String uid;
    private String upw;
    private String nm;
    private String pic;
}
