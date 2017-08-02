package com.weiyu.offer;

/**
 * Created by Wei Yu on 2017/7/28.
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class PatternMatcher {
    public boolean match(char[] str, char[] pattern)
    {
        if(null == str || null == pattern){
            return false;
        }
        return matchAlgorithm(str, 0, pattern,0);
    }

    public boolean matchAlgorithm(char[] str, int strIndex, char[] pattern, int patternIndex){
        if(strIndex == str.length && patternIndex == pattern.length){
            return true;
        }else if(strIndex != str.length && patternIndex == pattern.length){
            return false;
        }else if(patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*'){
            //如果模式第二位是*
            if((strIndex < str.length && str[strIndex] == pattern[patternIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)){
                return matchAlgorithm(str,strIndex,pattern,patternIndex + 2) //匹配了0个字符
                        || matchAlgorithm(str,strIndex + 1,pattern,patternIndex + 2) // 匹配了一个字符
                        || matchAlgorithm(str,strIndex + 1,pattern,patternIndex); //匹配了1一个字符，并且还要继续匹配
            }else{
                return matchAlgorithm(str,strIndex,pattern,patternIndex + 2);
            }
        }else if((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (strIndex != str.length && pattern[patternIndex] == '.')){
            //如果模式第二位不是*，则需两个数组一一匹配，如果匹配成功，则继续往下一个index匹配
            return matchAlgorithm(str,strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }

    public static void main(String... args){
        boolean flag = new PatternMatcher().match("a".toCharArray(), ".".toCharArray());
        System.out.println(flag);
    }
}
