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

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import io.github.astrapi69.img.ImageExtensions;
import io.github.astrapi69.lang.ClassExtensions;

/**
 * The class {@link IconExtensions} provides extension methods for operations with {@link Icon}
 * objects
 */
public class IconExtensions
{

	/**
	 * Converts the given {@link Icon} object to a {@link Image} object
	 * 
	 * @param icon
	 *            the icon to convert
	 * @return the {@link Image} object
	 */
	public static Image toImage(Icon icon)
	{
		if (icon instanceof ImageIcon)
		{
			return ((ImageIcon)icon).getImage();
		}
		return toBufferedImage(icon);
	}

	/**
	 * Stores the given {@link Icon} object to the given {@link File} object in the given format
	 * name
	 *
	 * @param icon
	 *            the icon to store
	 * @param formatName
	 *            the format name examples 'png' or 'jpg' description: Standard BMP Image Writer
	 *            format names: [bmp, BMP] description: Standard JPEG Image Writer format names:
	 *            [JPEG, jpeg, JPG, jpg] description: Standard WBMP Image Writer format names:
	 *            [wbmp, WBMP] description: Standard PNG image writer format names: [png, PNG]
	 *            description: Standard GIF image writer format names: [gif, GIF] description:
	 *            Standard TIFF image writer format names: [tif, TIF, tiff, TIFF]
	 * @param outputfile
	 *            the output file
	 * @return 's true if the given {@link Icon} object is stored to the given {@link File} object
	 *         otherwise false
	 */
	public static boolean storeIcon(Icon icon, String formatName, File outputfile)
	{
		try
		{
			ImageExtensions.write(toBufferedImage(icon), formatName, outputfile);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	/**
	 * Converts the given {@link Icon} object to a {@link BufferedImage} object
	 *
	 * @param icon
	 *            the icon to convert
	 * @return the {@link BufferedImage} object
	 */
	public static BufferedImage toBufferedImage(Icon icon)
	{
		if (icon instanceof ImageIcon)
		{
			Image image = ((ImageIcon)icon).getImage();
			return ImageExtensions.toBufferedImage(image);
		}
		GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice graphicsDevice = graphicsEnvironment.getDefaultScreenDevice();
		GraphicsConfiguration graphicsConfiguration = graphicsDevice.getDefaultConfiguration();
		BufferedImage bufferedImage = graphicsConfiguration
			.createCompatibleImage(icon.getIconWidth(), icon.getIconHeight());
		Graphics2D graphics2D = bufferedImage.createGraphics();
		icon.paintIcon(null, graphics2D, 0, 0);
		graphics2D.dispose();
		return bufferedImage;
	}

	/**
	 * Sets the icon image from the given resource name and add it to the given window object.
	 *
	 * @param resourceName
	 *            The name from the resource. This includes the absolute path to the image icon from
	 *            the classpath.
	 * @param window
	 *            the window in which to set the icon image.
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void setIconImage(final String resourceName, final Window window)
		throws IOException
	{
		final InputStream isLogo = ClassExtensions.getResourceAsStream(resourceName);
		final BufferedImage biLogo = ImageIO.read(isLogo);
		window.setIconImage(biLogo);
	}

}
