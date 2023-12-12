package com.yinhai.servlet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
public class test {
    public static void main(String[] args) {
        String s = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:120.0) Gecko/20100101 Firefox/120.0";
        String regStr = "\\(.+\\)";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(s);
        matcher.find();
        String group = matcher.group(0);
        String s1 = group.replaceAll("\\(|\\)", "");
        System.out.println(s1);

    }
}
