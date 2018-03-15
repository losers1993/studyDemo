package com.liu.learn.thumbnailator;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtil {
	private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	private static final Random r = new Random();
	
	public static String generateThumbnail(CommonsMultipartFile multipartFile, String fileName, String targetAddr) {
		String realFileName = getRealFileName();
		String extension = getExtension(fileName);
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName + extension;
		
		File newFile = new File(PathUtil.getBasePath() + relativeAddr);
		
		try {
			Thumbnails.of(multipartFile.getInputStream()).size(200, 200)
				.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/image.jpg")), 0.25f)
				.outputQuality(0.8f).toFile(newFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return relativeAddr;
	}
	
	public static String getRealFileName() {
		int rannum = r.nextInt(89999) + 10000;
		return simpleDateFormat.format(new Date()) + rannum;
	}
	
	public static String getExtension(String fileName) {
		return fileName.substring(fileName.lastIndexOf("."));
	}
	
	public static void makeDirPath(String targetAddr) {
		String realPath = PathUtil.getBasePath() + targetAddr;
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
	}
}
