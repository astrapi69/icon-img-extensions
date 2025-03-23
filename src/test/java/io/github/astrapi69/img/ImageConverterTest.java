package io.github.astrapi69.img;

import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ImageConverterTest
{

	@Test
	void testConvertJpgToPng() throws IOException
	{
		// Arrange
		File jpgFile = new File("src/test/resources/test-image.jpg");
		assertTrue(jpgFile.exists(), "Input JPEG file must exist for the test");

		// Act
		File pngFile = ImageConverter.convertJpgToPng(jpgFile);

		// Assert
		assertNotNull(pngFile, "Output PNG file should not be null");
		assertTrue(pngFile.exists(), "Output PNG file should exist");
		assertTrue(pngFile.getName().endsWith(".png"), "Output file should have .png extension");

		BufferedImage pngImage = ImageExtensions.read(pngFile);
		assertNotNull(pngImage, "BufferedImage should be readable from PNG file");

		// Cleanup
		assertTrue(pngFile.delete(), "PNG file should be deleted after test");
	}
}
