package com.green.greengram.feedComment.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.beans.ConstructorProperties;

@Data
public class FeedCommentDeleteReq {
    @Schema(name = "feed_comment_id")
    private Long feedCommentId;
    @Schema(name = "signed_user_id")
    private Long signedUserId;

    @ConstructorProperties({"feed_comment_id", "signed_user_id"})
    public FeedCommentDeleteReq(Long feedCommentId, Long signedUserId) {
        this.feedCommentId = feedCommentId;
        this.signedUserId = signedUserId;
    }
}
