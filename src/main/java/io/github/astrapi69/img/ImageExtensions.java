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

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import lombok.extern.java.Log;

/**
 * The class {@link ImageExtensions} provides extension methods for several operations with
 * {@link BufferedImage} objects
 */
@Log
public class ImageExtensions
{

	/**
	 * Converts the given {@link Image} object to a {@link Icon} object
	 *
	 * @param image
	 *            the image to convert
	 * @return the {@link Icon} object
	 */
	public static Icon toIcon(Image image)
	{
		return new ImageIcon(image);
	}

	/**
	 * Generates a new {@link BufferedImage} object with the given parameters
	 *
	 * @param width
	 *            the width
	 * @param height
	 *            the height
	 *
	 * @return The new {@link BufferedImage} object
	 */
	public BufferedImage newBufferedImage(int width, int height)
	{
		return newBufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	}

	/**
	 * Generates a new {@link BufferedImage} object with the given parameters
	 *
	 * @param width
	 *            the width
	 * @param height
	 *            the height
	 * @param imageType
	 *            the type of the image
	 *
	 * @return The new {@link BufferedImage} object
	 */
	public BufferedImage newBufferedImage(int width, int height, int imageType)
	{
		return new BufferedImage(width, height, imageType);
	}

	/**
	 * Generates a random {@link BufferedImage} object with the given parameters.
	 *
	 * @param width
	 *            the width
	 * @param height
	 *            the height
	 * @param imageType
	 *            the type of the image
	 *
	 * @return The generated {@link BufferedImage}.
	 */
	public static BufferedImage randomBufferedImage(final int width, final int height,
		final int imageType)
	{
		final BufferedImage img = new BufferedImage(width, height, imageType);
		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				img.setRGB(x, y, (int)(Math.random() * 256));
			}
		}
		return img;
	}

	/**
	 * Concatenate the given list of BufferedImage objects to one image and returns the concatenated
	 * BufferedImage object.
	 *
	 * @param imgCollection
	 *            the BufferedImage collection
	 * @param width
	 *            the width of the image that will be returned.
	 * @param height
	 *            the height of the image that will be returned.
	 * @param imageType
	 *            type of the created image
	 * @param concatenationDirection
	 *            the direction of the concatenation.
	 * @return the buffered image
	 */
	public static BufferedImage concatenateImages(final List<BufferedImage> imgCollection,
		final int width, final int height, final int imageType,
		final Direction concatenationDirection)
	{
		final BufferedImage img = new BufferedImage(width, height, imageType);
		int x = 0;
		int y = 0;
		for (final BufferedImage bi : imgCollection)
		{
			final boolean imageDrawn = img.createGraphics().drawImage(bi, x, y, null);
			if (!imageDrawn)
			{
				throw new RuntimeException("BufferedImage could not be drawn:" + bi.toString());
			}
			if (concatenationDirection.equals(Direction.vertical))
			{
				y += bi.getHeight();
			}
			else
			{
				x += bi.getWidth();
			}
		}
		return img;
	}

	/**
	 * Gets the buffered image from the given byte array.
	 *
	 * @param byteArray
	 *            the byte array
	 * @return the buffered image
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static BufferedImage read(final byte[] byteArray) throws IOException
	{
		return ImageIO.read(new ByteArrayInputStream(byteArray));
	}

	/**
	 * Gets the buffered image from the given byte array quietly.
	 *
	 * @param byteArray
	 *            the byte array
	 * @return the buffered image or null if the read process failed.
	 */
	public static BufferedImage readQuietly(final byte[] byteArray)
	{
		BufferedImage img = null;
		try
		{
			img = read(byteArray);
		}
		catch (IOException e)
		{
			log.log(Level.SEVERE, "Reading image failed.", e);
		}
		return img;
	}

	/**
	 * Gets the buffered image from the given byte array quietly.
	 *
	 * @param input
	 *            the input
	 * @return the buffered image or null if the read process failed.
	 */
	public static BufferedImage readQuietly(final InputStream input)
	{
		BufferedImage img = null;
		try
		{
			img = ImageIO.read(input);
		}
		catch (IOException e)
		{
			log.log(Level.SEVERE, "Reading image failed.", e);
		}
		return img;
	}

	/**
	 * Converts the given BufferedImage to a byte array.
	 *
	 * @param bi
	 *            the bi
	 * @param formatName
	 *            the format name examples 'png' or 'jpg' description: Standard BMP Image Writer
	 *            format names: [bmp, BMP] description: Standard JPEG Image Writer format names:
	 *            [JPEG, jpeg, JPG, jpg] description: Standard WBMP Image Writer format names:
	 *            [wbmp, WBMP] description: Standard PNG image writer format names: [png, PNG]
	 *            description: Standard GIF image writer format names: [gif, GIF] description:
	 *            Standard TIFF image writer format names: [tif, TIF, tiff, TIFF]
	 * @return the byte[]
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static byte[] toByteArray(final BufferedImage bi, final String formatName)
		throws IOException
	{
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream())
		{
			ImageIO.write(bi, formatName, baos);
			baos.flush();
			return baos.toByteArray();
		}
	}

	/**
	 * Unweave a secret message from the given {@link BufferedImage}. To weave a secret message to a
	 * {@link BufferedImage} object use the corresponding method
	 * {@link ImageExtensions#weaveInto(BufferedImage, String)}
	 *
	 * @param bufferedImage
	 *            the buffered image with the secret message
	 * @return the secret message that was weaved into the given {@link BufferedImage} object
	 */
	public static String unweaveFrom(final BufferedImage bufferedImage)
	{
		final int width = bufferedImage.getWidth();
		final int height = bufferedImage.getHeight();
		final int messageLength = bufferedImage.getRGB(0, 0) & 0xff;
		final StringBuilder sb = new StringBuilder();
		for (int row = 0, j = 0, i = 1; row < height; row++)
		{
			for (int column = 0; column < width && j < messageLength; column++, i++)
			{

				if (i % 11 == 0)
				{
					final int result = bufferedImage.getRGB(column, row);

					int charAtPosition = (result >> 16 & 0x7) << 5;

					charAtPosition |= (result >> 8 & 0x7) << 2;

					charAtPosition |= result & 0x3;
					sb.append((char)charAtPosition);
					j++;
				}
			}
		}
		return sb.toString();
	}

	/**
	 * Weave the given secret message into the given {@link BufferedImage}. Preconditions for the
	 * secret message the length must not be greater the 255 and the given image should be not too
	 * small size, that means 'message.length() * 11 &gt; width * height' <br>
	 * <br>
	 * To unweave the secret message use the corresponding
	 * {@link ImageExtensions#unweaveFrom(BufferedImage)}
	 *
	 * @param bufferedImage
	 *            the buffered image
	 * @param message
	 *            the secret message
	 * @return the buffered image with the secret message weaved in.
	 */
	public static BufferedImage weaveInto(final BufferedImage bufferedImage, final String message)
	{
		final int width = bufferedImage.getWidth();
		final int height = bufferedImage.getHeight();

		if (message.length() > 255)
		{
			throw new IllegalArgumentException("Given message is to large(max 255 characters)");
		}
		if (message.length() * 11 > width * height)
		{
			throw new IllegalArgumentException(
				"Given image is to small. message.length() * 11 > width * height");
		}

		final byte[] messageBytes = message.getBytes();

		int messageLengthDecode = bufferedImage.getRGB(0, 0) >> 8 << 8;

		messageLengthDecode |= message.length();
		bufferedImage.setRGB(0, 0, messageLengthDecode);

		for (int i = 1, messagePosition = 0, row = 0, j = 0; row < height; row++)
		{
			for (int column = 0; column < width && j < messageBytes.length; column++, i++)
			{

				if (i % 11 == 0)
				{

					int rgb = bufferedImage.getRGB(column, row);

					final int a = rgb >> 24 & 0xff;

					int r = (rgb >> 16 & 0xff) >> 3 << 3;
					r = r | messageBytes[messagePosition] >> 5;

					int g = (rgb >> 8 & 0xff) >> 3 << 3;
					g = g | messageBytes[messagePosition] >> 2 & 7;

					int b = (rgb & 0xff) >> 2 << 2;
					b = b | messageBytes[messagePosition] & 0x3;

					rgb = 0;
					rgb = rgb | a << 24;
					rgb = rgb | r << 16;
					rgb = rgb | g << 8;

					rgb = rgb | b;

					bufferedImage.setRGB(column, row, rgb);
					messagePosition++;
					j++;
				}
			}
		}
		return bufferedImage;
	}

	/**
	 * Convenience method to write the given {@link BufferedImage} object to the given {@link File}
	 * object.
	 *
	 * @param bufferedImage
	 *            the {@link BufferedImage} object to be written.
	 * @param formatName
	 *            the format name examples 'png' or 'jpg' description: Standard BMP Image Writer
	 *            format names: [bmp, BMP] description: Standard JPEG Image Writer format names:
	 *            [JPEG, jpeg, JPG, jpg] description: Standard WBMP Image Writer format names:
	 *            [wbmp, WBMP] description: Standard PNG image writer format names: [png, PNG]
	 *            description: Standard GIF image writer format names: [gif, GIF] description:
	 *            Standard TIFF image writer format names: [tif, TIF, tiff, TIFF]
	 * @param outputfile
	 *            the output file
	 * @return the file
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static File write(final BufferedImage bufferedImage, final String formatName,
		final File outputfile) throws IOException
	{
		ImageIO.write(bufferedImage, formatName, outputfile);
		return outputfile;
	}

	/**
	 * Converts the given {@link Image} object to a {@link BufferedImage} object
	 *
	 * @param image
	 *            the image to convert
	 * @return the {@link BufferedImage} object
	 */
	public static BufferedImage toBufferedImage(Image image)
	{
		if (image instanceof BufferedImage)
		{
			return (BufferedImage)image;
		}

		GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice graphicsDevice = graphicsEnvironment.getDefaultScreenDevice();
		GraphicsConfiguration graphicsConfiguration = graphicsDevice.getDefaultConfiguration();

		BufferedImage bufferedImage = graphicsConfiguration.createCompatibleImage(
			image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);

		Graphics2D graphics2D = bufferedImage.createGraphics();
		graphics2D.drawImage(image, 0, 0, null);
		graphics2D.dispose();
		return bufferedImage;
	}
}
