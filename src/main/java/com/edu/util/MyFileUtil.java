package com.edu.util;

import java.util.UUID;

public class MyFileUtil {
    public static String getFileName(String filename){
        if(filename.length() > 50){
            filename = filename.substring(filename.length() - 50);
        }

        return UUID.randomUUID().toString().replace("-","") + filename;
    }
}
