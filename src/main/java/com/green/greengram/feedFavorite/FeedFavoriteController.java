package com.green.greengram.feedFavorite;

import com.green.greengram.common.model.ResultDto;
import com.green.greengram.feedFavorite.model.FeedFavoriteToggleReq;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/feed/favorite")
@Slf4j
@Tag(name = "Feed 댓글", description = "댓글관련")
public class FeedFavoriteController {
    private final FeedFavoriteService service;

    @GetMapping
    @Operation(summary = "좋아요", description = "Toggle 처리")
    public ResultDto<Integer> toggleFavorite(@ModelAttribute FeedFavoriteToggleReq p){
        int result = service.toggleFavorite(p);

        return ResultDto.<Integer>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(result == 1 ? "좋아요 처리" : "좋아요 취소").
                resultData(result).
                build();
    }
}
