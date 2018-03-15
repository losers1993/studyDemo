package com.liu.learn.thumbnailator;

public class PathUtil {
	private static String separator = System.getProperty("file.separator");
	
	public static String getBasePath() {
		String basePath = "";
		String os = System.getProperty("os.name");
		if(os.toLowerCase().startsWith("win")) {
			basePath = "D:/java";
		} else {
			
		}
		basePath.replace("/", separator);
		return basePath;
	}
	
	public static String getImagePath(Long shopId) {
		String imagePath = "" + shopId + "/";
		return imagePath.replace("/", separator);
	}
}
