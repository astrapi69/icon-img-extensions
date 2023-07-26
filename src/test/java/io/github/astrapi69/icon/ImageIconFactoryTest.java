/**
 * The MIT License
 *
 * Copyright (C) 2021 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.icon;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.apache.batik.transcoder.TranscoderException;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import io.github.astrapi69.file.search.PathFinder;
import io.github.astrapi69.lang.ClassExtensions;

/**
 * The unit test class for the class {@link ImageIconFactory}
 *
 * @author Asterios Raptis
 */
class ImageIconFactoryTest
{

	/**
	 * Test for method {{@link ImageIconFactory#newImageIcon(BufferedImage)}
	 */
	@Test
	public void testNewImageIconWithBufferedImage() throws IOException
	{
		ImageIcon actual;
		String imageName;

		File imgDir = new File(PathFinder.getSrcTestResourcesDir(), "img");

		File xmas = new File(imgDir, "xmas");
		imageName = "stars.png";
		File stars = new File(xmas, imageName);

		BufferedImage bufferedImage = ImageIO.read(stars);

		actual = ImageIconFactory.newImageIcon(bufferedImage);
		assertNotNull(actual);
	}

	/**
	 * Test for method {{@link ImageIconFactory#newImageIcon(BufferedImage, String)}
	 */
	@Test
	public void testNewImageIconWithBufferedImageAndDescription() throws IOException
	{
		ImageIcon actual;
		String imageName;
		String description;

		description = "A description";

		File imgDir = new File(PathFinder.getSrcTestResourcesDir(), "img");

		File xmas = new File(imgDir, "xmas");
		imageName = "stars.png";
		File stars = new File(xmas, imageName);

		BufferedImage bufferedImage = ImageIO.read(stars);

		actual = ImageIconFactory.newImageIcon(bufferedImage, description);
		assertNotNull(actual);
	}

	/**
	 * Test for method {{@link ImageIconFactory#newImageIcon(String, String)}
	 */
	@Test
	public void testNewImageIcon()
	{
		ImageIcon actual;
		String relativeImagePath;
		String description;

		description = "A description";
		relativeImagePath = "img/xmas/stars.png";
		actual = ImageIconFactory.newImageIcon(relativeImagePath, description);
		assertNotNull(actual);
	}

	/**
	 * Test for method {{@link ImageIconFactory#newImageIcon(File)}
	 */
	@Test
	public void testNewImageIconWithFile()
	{
		ImageIcon actual;
		String imageName;

		File imgDir = new File(PathFinder.getSrcTestResourcesDir(), "img");

		File xmas = new File(imgDir, "xmas");
		imageName = "stars.png";
		File stars = new File(xmas, imageName);


		actual = ImageIconFactory.newImageIcon(stars);
		assertNotNull(actual);
	}

	/**
	 * Test for method {{@link ImageIconFactory#newImageIcon(File, String)}
	 */
	@Test
	public void testNewImageIconWithFileAndDescription()
	{
		ImageIcon actual;
		String imageName;
		String description;

		File imgDir = new File(PathFinder.getSrcTestResourcesDir(), "img");

		File xmas = new File(imgDir, "xmas");
		imageName = "stars.png";
		File stars = new File(xmas, imageName);

		description = "A description";

		actual = ImageIconFactory.newImageIcon(stars, description);
		assertNotNull(actual);
	}

	/**
	 * Test for method {{@link ImageIconFactory#newImageIcon(String, int, int)}
	 */
	@Test
	public void testNewImageIconWithRelativePathWidthAndHeight()
	{
		ImageIcon actual;
		String relativeImagePath;
		int newWidth;
		int newHeight;

		relativeImagePath = "img/xmas/stars.png";
		newWidth = 100;
		newHeight = 100;
		actual = ImageIconFactory.newImageIcon(relativeImagePath, newWidth, newHeight);
		assertNotNull(actual);
	}


	/**
	 * Test for method {{@link ImageIconFactory#newImageIcon(URL)}
	 *
	 * @throws MalformedURLException
	 *             If a protocol handler for the URL could not be found, or if some other error
	 *             occurred while constructing the URL
	 */
	@Test
	public void testNewImageIconWithUrl() throws MalformedURLException
	{
		ImageIcon actual;
		String imageName;

		File imgDir = new File(PathFinder.getSrcTestResourcesDir(), "img");

		File xmas = new File(imgDir, "xmas");
		imageName = "stars.png";
		File stars = new File(xmas, imageName);


		actual = ImageIconFactory.newImageIcon(stars.toURI().toURL());
		assertNotNull(actual);
	}


	/**
	 * Test for method {{@link ImageIconFactory#newImageIcon(URL, String)}
	 *
	 * @throws MalformedURLException
	 *             If a protocol handler for the URL could not be found, or if some other error
	 *             occurred while constructing the URL
	 */
	@Test
	public void testNewImageIconWithUrlAndDescription() throws MalformedURLException
	{
		ImageIcon actual;
		String imageName;
		String description;

		File imgDir = new File(PathFinder.getSrcTestResourcesDir(), "img");

		File xmas = new File(imgDir, "xmas");
		imageName = "stars.png";
		File stars = new File(xmas, imageName);
		description = "A description";


		actual = ImageIconFactory.newImageIcon(stars.toURI().toURL(), description);
		assertNotNull(actual);
	}

	/**
	 * Test for method {{@link ImageIconFactory#newImageIconFromSVG(String, float, float, String)}
	 *
	 * @throws TranscoderException
	 *             is thrown when a transcoder is not able to transcode its input
	 */
	@Test
	public void testNnewImageIconFromSVG() throws TranscoderException
	{
		ImageIcon actual;
		String relativeImagePath;
		float targetWidth;
		float targetHeight;
		String description;

		relativeImagePath = "img/xmas/greendices.svg";
		targetWidth = 10f;
		targetHeight = 10f;
		description = "A description";
		actual = ImageIconFactory.newImageIconFromSVG(relativeImagePath, targetWidth, targetHeight,
			description);
		assertNotNull(actual);
	}

	/**
	 * Test for method
	 * {{@link ImageIconFactory#newImageIconFromSVG(InputStream, float, float, String)}
	 *
	 * @throws TranscoderException
	 *             is thrown when a transcoder is not able to transcode its input
	 */
	@Test
	public void testNnewImageIconFromSVGWithInputStream() throws TranscoderException
	{
		ImageIcon actual;
		String relativeImagePath;
		float targetWidth;
		float targetHeight;
		String description;
		InputStream svgImageAsStream;

		relativeImagePath = "img/xmas/greendices.svg";

		svgImageAsStream = ClassExtensions.getResourceAsStream(relativeImagePath);
		targetWidth = 10f;
		targetHeight = 10f;
		description = "A description";
		actual = ImageIconFactory.newImageIconFromSVG(svgImageAsStream, targetWidth, targetHeight,
			description);
		assertNotNull(actual);
	}

	/**
	 * Test for method {{@link ImageIconFactory#newImageIconFromSVG(String, float, float)}
	 *
	 * @throws TranscoderException
	 *             is thrown when a transcoder is not able to transcode its input
	 */
	@Test
	public void testNewImageIconFromSVGWithRelativePathWidthAndHeight() throws TranscoderException
	{
		ImageIcon actual;
		String relativeImagePath;
		float targetWidth;
		float targetHeight;

		relativeImagePath = "img/xmas/greendices.svg";
		targetWidth = 10f;
		targetHeight = 10f;
		actual = ImageIconFactory.newImageIconFromSVG(relativeImagePath, targetWidth, targetHeight);
		assertNotNull(actual);
	}

	/**
	 * Test method for {@link ImageIconFactory} with {@link BeanTester}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(ImageIconFactory.class);
	}

}
