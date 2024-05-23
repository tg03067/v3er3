package com.green.greengram.userfollow;

import com.green.greengram.common.model.ResultDto;
import com.green.greengram.userfollow.model.UserFollowPostReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/user/follow")
public class UserFollowController {
    private final UserFollowService Service;

    @PostMapping
    public ResultDto<Integer> insUserFollow(@RequestBody UserFollowPostReq p){
        int result = Service.insUserFollow(p);

        return ResultDto.<Integer>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(result).
                build();
    }
    @DeleteMapping
    public ResultDto<Integer> delUserFollow(@ParameterObject @ModelAttribute UserFollowPostReq p){
        int result = Service.delUserFollow(p);

        return ResultDto.<Integer>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(result).
                build();
    }
}
