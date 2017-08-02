package com.weiyu.offer.io;


import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by Wei Yu on 2017/7/24.
 */
public class DirList {
    public static void main(String[] args){
        File file = new File("E:\\虞威-开题报告");
        String[] list = file.list(new DirFilter("0{1}"));
        Arrays.sort(list);
        for(String name : list){
            System.out.println(name);
        }
    }
}


class DirFilter implements FilenameFilter{
    private Pattern pattern;

    public DirFilter(String regex){
        this.pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File dir, String name) {
        if(name.endsWith(".pdf"))
            return true;
        return false;
    }
}
