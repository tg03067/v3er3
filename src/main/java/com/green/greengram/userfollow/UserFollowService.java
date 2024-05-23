package com.green.greengram.userfollow;

import com.green.greengram.userfollow.model.UserFollowPostReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserFollowService {
    private final UserFollowMapper mapper;

    public int insUserFollow(UserFollowPostReq p) {
        return mapper.insUserFollow(p);
    }
    public int delUserFollow(UserFollowPostReq p) {
        return mapper.delUserFollow(p);
    }
}
