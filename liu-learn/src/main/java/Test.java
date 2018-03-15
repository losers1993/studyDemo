import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class Test {
	public static void main(String args[]) {
		String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		File directory = new File("C:/Users/Administrator/Desktop/8364db30e924b89920b753e568061d95087bf6c5.jpg");
		try {
			Thumbnails.of(directory).size(200, 200)
				.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath +"/static/docs/images/header-bg.png")), 0.25f)
				.outputQuality(0.8f).toFile(new File("C:/Users/Administrator/Desktop/8364db30e924b89920b753e568061d95087bf6c5.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
