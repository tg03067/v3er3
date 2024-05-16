package com.green.greengram.feedFavorite;

import com.green.greengram.feedFavorite.model.FeedFavoriteToggleReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeedFavoriteService {
    private final FeedFavoriteMapper mapper;

    public int toggleFavorite(FeedFavoriteToggleReq p){
        int delAffectedRows = mapper.delFeedFavorite(p);
        if(delAffectedRows == 1){
            return 0;
        }
        return mapper.insFeedFavorite(p);
    }
}
