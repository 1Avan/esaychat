package com.ivan.controller;

import com.ivan.entity.constans.Constans;
import com.ivan.entity.vo.ResponseVO;
import com.ivan.exception.BusinessException;
import com.ivan.redis.RedisUtils;
import com.ivan.service.UserInfoService;
import com.wf.captcha.ArithmeticCaptcha;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController("acountContoller")
@RequestMapping("/account")
@Validated
@Slf4j
public class AcountContoller extends ABaseController {
    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 生成验证码
     *
     * @return
     */
    @RequestMapping("/checkCode")
    public ResponseVO checkCode() {
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(100, 42);
        String code = captcha.text();
        String codeKey = UUID.randomUUID().toString();

//        log.info("发送code{}", code);
        redisUtils.set(Constans.REDIS_KEY_CHECK_CODE + codeKey, code, Constans.REDIS_TIME_1MIN * 10);
        String checkCode2Base64 = captcha.toBase64();
        Map<String, String> result = new HashMap<>();
        result.put("checkCode", checkCode2Base64);
        result.put("checkCodeKey", codeKey);
        return getSuccessResponseVO(result);
    }

    @RequestMapping("/register")
    public ResponseVO register(@NotEmpty String checkCodeKey,
                               @NotEmpty @Email String email,
                               @NotEmpty String password,
                               @NotEmpty String nickName,
                               @NotEmpty String checkCode) {
        log.info("checkCodeKey{},checkCode{}", checkCodeKey, checkCode);
        try {

            if (!checkCode.equalsIgnoreCase((String) redisUtils.get(Constans.REDIS_KEY_CHECK_CODE + checkCodeKey))) {
                throw new BusinessException("验证码输入错误");
            }
            userInfoService.register(email, nickName, password);
            return getSuccessResponseVO(null);
        } finally {
            redisUtils.del(Constans.REDIS_KEY_CHECK_CODE + checkCodeKey);
        }
    }

    @RequestMapping("/login")
    public ResponseVO login(@NotEmpty String checkCodeKey,
                            @NotEmpty @Email String email,
                            @NotEmpty String password,
                            @NotEmpty String checkCode) {
        log.info("checkCodeKey{},checkCode{}", checkCodeKey, checkCode);

        try {
            if (!checkCode.equalsIgnoreCase((String) redisUtils.get(Constans.REDIS_KEY_CHECK_CODE + checkCodeKey))) {
                throw new BusinessException("验证码输入错误");
            }
            //TODO 这里要写token逻辑
            return getSuccessResponseVO("token");
        } finally {
            redisUtils.del(Constans.REDIS_KEY_CHECK_CODE + checkCodeKey);
        }
    }

}
