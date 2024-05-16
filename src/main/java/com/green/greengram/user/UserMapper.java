package com.green.greengram.user;

import com.green.greengram.user.model.SignupPostReq;
import com.green.greengram.user.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser(SignupPostReq p);
    User selUserById(String uid);
}
