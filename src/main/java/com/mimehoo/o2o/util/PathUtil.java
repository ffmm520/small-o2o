package com.mimehoo.o2o.util;

import java.util.Properties;

/**
 * 文件路径处理
 */
public class PathUtil {
    // 系统分隔符
    private static final String separator = System.getProperty("file.separator");

    // 项目图片根路径
    public static String getImgBasePath() {
        String os = System.getProperty("os.name");
        String basePath = "";
        if (os.toLowerCase().startsWith("win")) {
            basePath = "D:/projectdev/image/";
        } else {
            basePath = "/home/baboon/image/";
        }
        return basePath.replace("/", separator);
    }

    // 项目图片子路径
    public static String getShopImagePath(long shopId) {
        String imagePath = "/upload/item/shop/" + shopId + "/";
        return imagePath.replace("/", separator);
    }
}
