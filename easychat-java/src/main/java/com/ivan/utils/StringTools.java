package com.ivan.utils;

import com.ivan.entity.constans.Constans;
import com.ivan.enums.UserContactTypeEnum;
import jodd.util.RandomString;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

public class StringTools {


    public static String getUserId(){
        return UserContactTypeEnum.USER.getPrefix()+getRandomNumber(Constans.LENGTH_11);
    }
    public static String getRandomNumber(Integer count){
        return RandomStringUtils.random(count,false,true);
    }
    public static String getRandomString(Integer count){
        return RandomStringUtils.random(count,true,true);
    }

    public static final String encodeMd5(String originString){
        return StringUtils.isEmpty(originString)?null: DigestUtils.md5Hex(originString);
    }
}
