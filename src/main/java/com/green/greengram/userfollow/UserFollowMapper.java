package com.green.greengram.userfollow;

import com.green.greengram.userfollow.model.UserFollowPostReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserFollowMapper {
    int insUserFollow(UserFollowPostReq p);
    int delUserFollow(UserFollowPostReq p);
}
