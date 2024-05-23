package com.green.greengram.user;

import com.green.greengram.user.model.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser(SignupPostReq p);
    User selUserById(String uid);
    int updProfilePic(UserProfilePatchReq p);
    UserInfoGetRes selProfileUserInfo(UserInfoGetReq p);
}
