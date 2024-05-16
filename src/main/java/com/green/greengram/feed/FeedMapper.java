package com.green.greengram.feed;

import com.green.greengram.feed.model.FeedGetReq;
import com.green.greengram.feed.model.FeedGetRes;
import com.green.greengram.feed.model.FeedPicsPostDto;
import com.green.greengram.feed.model.FeedPostReq;
import com.green.greengram.feedComment.model.FeedCommentGetRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedMapper {
    int postFeed(FeedPostReq p);
    int postFeedPics(FeedPicsPostDto p);
    List<FeedGetRes> selFeed(FeedGetReq p);
    List<String> selFeedPicsByFeedId(long feedId);
    List<FeedCommentGetRes> selFeedCommentTopBy4ByFeedId(long feedId);
}
