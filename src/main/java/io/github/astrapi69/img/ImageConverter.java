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

import static io.github.astrapi69.img.ImageExtensions.write;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * The class {@link ImageConverter} provides utility methods to convert image formats
 */
public final class ImageConverter
{

	/**
	 * Private constructor to prevent instantiation
	 */
	private ImageConverter()
	{
	}

	/**
	 * Converts a given JPEG image file to a PNG image file
	 *
	 * @param jpgFile
	 *            the input JPEG file
	 * @return the output PNG file
	 * @throws IOException
	 *             if an I/O error occurs during reading or writing
	 */
	public static File convertJpgToPng(final File jpgFile) throws IOException
	{
		if (jpgFile == null || !jpgFile.exists())
		{
			throw new IllegalArgumentException("Input file is null or does not exist");
		}
		BufferedImage image = ImageExtensions.read(jpgFile);
		String pngFileName = jpgFile.getName().replaceFirst("[.][^.]+$", "") + ".png";
		File pngFile = new File(jpgFile.getParentFile(), pngFileName);
		return write(image, "png", pngFile);
	}
}
