package io.github.astrapi69.img;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class BrightenImageExtensionsTest
{


	@Test
	@Disabled("only local use")
	void testBrightenPngImage() throws IOException
	{
		// Arrange
		File originalImage = new File("src/test/resources/07-grandma-discovers-the-empty-pot.png");
		File brightenedImage = new File(
			"src/test/resources/test/07-grandma-discovers-the-empty-pot.png");
		float scaleFactor = 1.25f;

		// Act
		try
		{
			BrightenImageExtensions.brightenPngImage(originalImage, brightenedImage, scaleFactor);
		}
		catch (Exception e)
		{
			throw new IOException("Error during image processing", e);
		}

		// Assert
		assertTrue(brightenedImage.exists(), "Brightened image file should be created.");
		BufferedImage resultImage = ImageIO.read(brightenedImage);
		assertTrue(resultImage.getWidth() > 0 && resultImage.getHeight() > 0,
			"Brightened image should have valid dimensions.");
	}
}