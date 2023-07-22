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

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

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

}
