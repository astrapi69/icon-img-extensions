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
package io.github.astrapi69.img;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Icon;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import io.github.astrapi69.file.create.FileFactory;
import io.github.astrapi69.file.delete.DeleteFileExtensions;
import io.github.astrapi69.file.search.PathFinder;
import io.github.astrapi69.lang.ClassExtensions;

/**
 * The unit test class for the class {@link ImageExtensions}
 *
 * @author Asterios Raptis
 */
class ImageExtensionsTest
{

	/**
	 * Test for method {{@link ImageExtensions#toIcon(Image)}
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred
	 */
	@Test
	public void testToIcon() throws IOException
	{

		Icon actual;

		final BufferedImage img1 = ImageIO
			.read(ClassExtensions.getResourceAsStream("img/xmas/bell.png"));

		actual = ImageExtensions.toIcon(img1);
		assertNotNull(actual);
	}

	/**
	 * Test for method {{@link ImageExtensions#concatenateImages(List, int, int, int, Direction)}
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred
	 */
	@Test
	public void testConcatenateImages() throws IOException
	{
		final BufferedImage img1 = ImageIO
			.read(ClassExtensions.getResourceAsStream("img/xmas/bell.png"));
		final BufferedImage img2 = ImageIO
			.read(ClassExtensions.getResourceAsStream("img/xmas/greendices.png"));
		final BufferedImage img3 = ImageIO
			.read(ClassExtensions.getResourceAsStream("img/xmas/stars.png"));

		final List<BufferedImage> imgCollection = new ArrayList<>();
		imgCollection.add(img1);
		imgCollection.add(img2);
		imgCollection.add(img3);
		final BufferedImage verticalImage = ImageExtensions.concatenateImages(imgCollection,
			img1.getWidth(), img1.getHeight() + img2.getHeight() + img3.getHeight(),
			BufferedImage.TYPE_INT_RGB, Direction.vertical);
		final BufferedImage horizontalImage = ImageExtensions.concatenateImages(imgCollection,
			img1.getWidth() + img2.getWidth() + img3.getWidth(), img1.getHeight(),
			BufferedImage.TYPE_INT_RGB, Direction.horizontal);
		final File imgDir = new File(PathFinder.getSrcTestResourcesDir(), "img");
		final File xmasDir = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "img",
			"xmas");
		new File(imgDir, "img/xmas");
		final File verticalImg = new File(xmasDir, "verticalImg.jpg");
		ImageIO.write(verticalImage, "jpeg", verticalImg);

		final File horizontalImg = new File(xmasDir, "horizontalImg.jpg");
		ImageIO.write(horizontalImage, "jpeg", horizontalImg);
		// comment the following two lines to see the result.
		DeleteFileExtensions.delete(horizontalImg);
		DeleteFileExtensions.delete(verticalImg);
	}

	/**
	 * Test for method {ImageExtensions#randomBufferedImage(int, int, int)}.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testRandomBufferedImage() throws IOException
	{
		// file object
		final String filenameprefix = "random-generated";
		final String ext = "png";
		final File imgFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "img",
			filenameprefix + "." + ext);

		final boolean imgWritten = ImageIO.write(
			ImageExtensions.randomBufferedImage(340, 120, BufferedImage.TYPE_INT_ARGB), "png",
			imgFile);
		assertTrue(imgWritten);
		if (imgWritten)
		{
			DeleteFileExtensions.delete(imgFile);
		}
	}

	/**
	 * Test for method {@link ImageExtensions#unweaveFrom(BufferedImage)}
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testWeave() throws IOException
	{
		String actual;
		String expected;
		String filenameprefix;
		String ext;
		String secretMessage;
		File hImg;
		BufferedImage horizontalImg;
		String outputFileName;
		File outputfile;
		BufferedImage outputImg;
		// new scenario...
		filenameprefix = "bell";
		ext = "png";
		hImg = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "img", "xmas",
			filenameprefix + "." + ext);

		horizontalImg = ImageIO.read(hImg);
		secretMessage = "foo bar";
		ImageExtensions.weaveInto(horizontalImg, secretMessage);
		actual = ImageExtensions.unweaveFrom(horizontalImg);
		expected = secretMessage;
		assertEquals(expected, actual);

		outputFileName = filenameprefix + "output";
		outputfile = new File(PathFinder.getSrcTestResourcesDir(), outputFileName + "." + ext);
		FileFactory.newFile(outputfile);

		outputfile = ImageExtensions.write(horizontalImg, ext, outputfile);

		outputImg = ImageIO.read(outputfile);
		actual = ImageExtensions.unweaveFrom(outputImg);

		assertEquals(expected, actual);

		DeleteFileExtensions.delete(outputfile);

		// new scenario...
		filenameprefix = "key";
		ext = "png";
		hImg = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "img", "xmas",
			filenameprefix + "." + ext);

		horizontalImg = ImageIO.read(hImg);
		secretMessage = "very secret password";
		ImageExtensions.weaveInto(horizontalImg, secretMessage);
		actual = ImageExtensions.unweaveFrom(horizontalImg);
		expected = secretMessage;
		assertEquals(expected, actual);

		outputFileName = filenameprefix + "output";
		outputfile = new File(PathFinder.getSrcTestResourcesDir(), outputFileName + "." + ext);
		FileFactory.newFile(outputfile);

		outputfile = ImageExtensions.write(horizontalImg, ext, outputfile);

		outputImg = ImageIO.read(outputfile);
		actual = ImageExtensions.unweaveFrom(outputImg);

		assertEquals(expected, actual);

		DeleteFileExtensions.delete(outputfile);
	}

	/**
	 * Test method for {@link ImageExtensions} with {@link BeanTester}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(ImageExtensions.class);
	}

}