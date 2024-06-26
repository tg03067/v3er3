package com.green.greengram.user;

import com.green.greengram.common.model.ResultDto;
import com.green.greengram.user.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
@Tag(name = "유저 인터페이스", description = "회원가입, 로그인 등 인터페이스")
public class UserController {
    private final UserService service;

    @PostMapping("sign-up")
    @Operation(summary = "회원가입", description = "프로필 사진은 필수가 아닙니다.")
    public ResultDto<Integer> insUser(@RequestPart(required = false) MultipartFile pic,
                                      @RequestPart SignupPostReq p){
        int result = service.insUser(pic, p);

        return ResultDto.<Integer>builder().
                httpStatus(HttpStatus.OK).
                resultMsg("회원가입 성공").
                resultData(result).
                build();
    }
    @PostMapping("sign-in")
    @Operation(summary = "로그인 처리")
    public ResultDto<SignInRes> selUserById(@RequestBody SignInPostReq p){
        SignInRes res = service.selUserById(p);
        return ResultDto.<SignInRes>builder().
                httpStatus(HttpStatus.OK).
                resultMsg("로그인 성공").
                resultData(res).
                build();
    }
    @GetMapping
    @Operation(summary = "팔로워 확인")
    public ResultDto<UserInfoGetRes> userProfile(@ParameterObject @ModelAttribute UserInfoGetReq p){
        UserInfoGetRes result = service.selUserProfile(p);

        return ResultDto.<UserInfoGetRes>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(result).
                build();
    }

    @PatchMapping("pic")
    @Operation(summary = "프로필 사진 수정")
    public ResultDto<String> patchProfilePic(@ModelAttribute UserProfilePatchReq p){
        String result = service.updateUser(p);

        return ResultDto.<String>builder().
                httpStatus(HttpStatus.OK).
                resultMsg("프로필 사진 변경 성공").
                resultData(result).
                build();
    }
}
