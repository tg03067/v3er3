package com.green.greengram.feedComment;

import com.green.greengram.feedComment.model.FeedCommentDeleteReq;
import com.green.greengram.feedComment.model.FeedCommentGetRes;
import com.green.greengram.feedComment.model.FeedCommentPostReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FeedCommentService {
    private final FeedCommentMapper mapper;

    public long postFeedComment(FeedCommentPostReq p){
        int affectedRows = mapper.postFeedComment(p);
        return p.getFeedCommentId();
    }
    public int delFeedComment(FeedCommentDeleteReq p){
        return mapper.delFeedComment(p);
    }
    public List<FeedCommentGetRes> selFeedComment(Long feedId){
        return mapper.selFeedComment(feedId);
    }
}
