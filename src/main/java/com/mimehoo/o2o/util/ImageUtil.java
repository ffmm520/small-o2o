package com.mimehoo.o2o.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Position;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

public class ImageUtil {
    private static final String basePath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random r = new Random();

    /**
     * @param thumbnail  上传的文件
     * @param targetAddr 文件存储路径
     * @return 生成文件名
     */
    public static String generateThumbnail(CommonsMultipartFile thumbnail, String targetAddr) {
        String realFileName = getRandomFileName();
        String extension = getFileExtension(thumbnail);
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + realFileName + extension;
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        try {
            Thumbnails.of(thumbnail.getInputStream()).size(200, 200)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.png")), 0.25f)
                    .outputQuality(0.8f).toFile(dest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @return 随机文件名
     */
    public static String getRandomFileName() {
        // 获取随机数
        int randomNum = r.nextInt(89999) + 10000;
        String nowTimeStr = sdf.format(new Date());
        return nowTimeStr + randomNum;
    }

    /**
     * 获取文件扩展名
     * @param thumbnail 上传文件
     * @return 文件扩展名
     */

    public static String getFileExtension(CommonsMultipartFile thumbnail) {
        String originalFilename = thumbnail.getOriginalFilename();
        assert originalFilename != null;
        return originalFilename.substring(originalFilename.lastIndexOf("."));
    }

    /**
     * 创建目标路径
     *
     * @param targetAddr 目标路径
     */
    public static void makeDirPath(String targetAddr) {
        String realFilePath = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFilePath);
        // 递归创建文件夹
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
    }

    public static void main(String[] args) throws IOException {
        Thumbnails.of(new File("/Users/baboon/Pictures/1608bm.jpg")).size(200, 200)
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.png")), 0.25f)
                .outputQuality(0.8f).toFile("/Users/baboon/Pictures/1608bm-new.jpg");
    }


}
