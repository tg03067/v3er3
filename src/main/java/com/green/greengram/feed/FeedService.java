package com.green.greengram.feed;

import com.green.greengram.common.CustomFileUtils;
import com.green.greengram.common.GlobalConst;
import com.green.greengram.feed.model.*;
import com.green.greengram.feedComment.model.FeedCommentGetRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FeedService {
    private final FeedMapper mapper;
    private final CustomFileUtils customFileUtils;

    @Transactional
    public FeedPostRes postFeed(List<MultipartFile> pics, FeedPostReq p){
        int result = mapper.postFeed(p);
        log.info(String.format("%d",result));
        FeedPicsPostDto picDto = FeedPicsPostDto.builder().feedId(p.getFeedId()).build();
        try {
            String path = String.format("feed/%d", p.getFeedId());
            customFileUtils.makeFolders(path);
            for(MultipartFile pic : pics){
                String saveFileName = customFileUtils.makeRandomFileName(pic);
                picDto.getFileNames().add(saveFileName);
                String target = String.format("%s/%s", path, saveFileName);
                customFileUtils.transferTo(pic, target);
;            }
            int affectedRowPics = mapper.postFeedPics(picDto);
            log.info(String.format("%d", affectedRowPics));
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("feed 등록 오류");
        }
        return FeedPostRes.builder().
                feedId(p.getFeedId()).
                pics(picDto.getFileNames()).
                build();
    }

    public List<FeedGetRes> selFeed(FeedGetReq p){
        List<FeedGetRes> list = mapper.selFeed(p);
        if(list.isEmpty()){
            return Collections.emptyList();
        }
        for(FeedGetRes res : list){
            List<String> pics = mapper.selFeedPicsByFeedId(res.getFeedId());
            res.setPics(pics);

            List<FeedCommentGetRes> comment = mapper.selFeedCommentTopBy4ByFeedId(res.getFeedId());
            boolean hasMoreComment = comment.size() == GlobalConst.COMMENT_SIZE_PER_FEED ;
            res.setIsMoreComment( hasMoreComment ? 1 : 0);
            if(hasMoreComment){
                comment.remove( comment.size() - 1 );
            }
            res.setComments(comment);
        }
        return list;
    }
}
