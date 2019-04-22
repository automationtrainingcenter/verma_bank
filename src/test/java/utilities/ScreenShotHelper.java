package utilities;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotHelper extends BrowserHelper {
	/**
	 * capture the screenshot using Selenium TakeScreenshot interface./ provide
	 * folder name and file name without .png extension
	 * 
	 * @param folderName
	 * @param fileName
	 */

	public static void captureScreenShot(WebDriver driver, String folderName, String fileName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcImg = ts.getScreenshotAs(OutputType.FILE);
		File destImg = new File(getFilePath(folderName, fileName + getDate() + ".png"));
		try {
			BufferedImage bi = ImageIO.read(srcImg);
			ImageIO.write(bi, "png", destImg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void alertScreenCapture(String folderName, String fileName) {
		Robot r;
		try {
			r = new Robot();
			BufferedImage bi = r.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(bi, "png", new File(getFilePath(folderName, fileName + getDate() + ".png")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
