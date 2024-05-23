package com.green.greengram.userfollow.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;

import java.beans.ConstructorProperties;

@Getter
public class UserFollowPostReq {
    @Schema(name = "from_user_id")
    private long fromUserId;
    @Schema(name = "to_user_id")
    private long toUserId;

    @ConstructorProperties({"from_user_id","to_user_id"})
    public UserFollowPostReq(long fromUserId, long toUserId) {
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
    }
}
