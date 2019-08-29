package com.ttmall.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPattern {
    /**
     * 匹配邮箱
     * @param email 邮箱
     * @return
     */
    public static boolean emailMatch(String email){
        Pattern p =  Pattern.compile( "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$");
        Matcher matcher = p.matcher(email);
        return matcher.matches();
    }
    public static boolean phoneMatch(String phone){
        Pattern p =  Pattern.compile("^((13[0-9])|(15[^4])|(18[0-9])|(17[0-9])|(147))\\d{8}$");
        Matcher matcher = p.matcher(phone);
        return matcher.matches();
    }
}
