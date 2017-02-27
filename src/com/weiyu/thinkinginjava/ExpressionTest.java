package com.weiyu.thinkinginjava;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by weiyu on 2017/2/17.
 */
public class ExpressionTest {
    public static void main(String... args){
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(.*)(\\d+)(.*)";
        Pattern p = Pattern.compile(pattern);

        Matcher matcher = p.matcher(line);
        int count = matcher.groupCount();
        System.out.println("count:" + matcher.groupCount());
        if(matcher.find()) {
            for (int i = 0; i < count; i++) {
                System.out.println(matcher.group(i));
            }
        }
    }
}
