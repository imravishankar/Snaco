package AbstractComponents;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

	private static final String SCREENSHOT_FOLDER = "screenshots/";

	// Call this method with WebDriver instance
	public static void takeScreenshot(WebDriver driver, String namePrefix) {
		// Create screenshots folder if it doesn't exist
		File screenshotDir = new File(SCREENSHOT_FOLDER);
		if (!screenshotDir.exists()) {
			screenshotDir.mkdir();
		}

		// Generate timestamp for unique filename
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String fileName = SCREENSHOT_FOLDER + namePrefix + "_" + timestamp + ".png";

		// Take and save screenshot
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File(fileName);

		try {
			FileUtils.copyFile(srcFile, destFile);
			System.out.println("Screenshot saved: " + destFile.getAbsolutePath());
		} catch (IOException e) {
			System.err.println("Failed to save screenshot: " + e.getMessage());
		}
	}
}
