package com.lianchuangjie.lianchuangjie.utils;


import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Base64Util {
    public static String generateImage(String imgStr, String imgDirPath, Long userSign) {
        File imgDir=new File(imgDirPath);
        if(!imgDir.exists())
            imgDir.mkdir();
        //获取图片类型
        String imgExt= imgStr.split(",")[0].split("[/;]")[1];
        imgStr=imgStr.split(",")[1];

        String fileName= userSign.toString() + "_" + UUIDUtil.getUUID()+"."+imgExt;
        String imgFilePath=imgDirPath+"/"+fileName;
        System.out.println(imgFilePath);
        try {
            byte[] bytes = Base64.decodeBase64(imgStr);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {
                    bytes[i] += 256;
                }
            }
            OutputStream out = Files.newOutputStream(Paths.get(imgFilePath));
            out.write(bytes);
            out.flush();
            out.close();
            return fileName;
        } catch (Exception e) {
            return null;
        }
    }
}
