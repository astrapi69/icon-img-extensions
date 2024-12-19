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

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.ImageIcon;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ImageIconPreloaderTest
{

	/**
	 * Tests the preloadIcon method to ensure that an icon is added to the cache
	 */
	@Test
	void testPreloadIcon()
	{
		String iconPath = "img/xmas/stars.png";
		ImageIconPreloader.loadIcon(iconPath);
		ImageIcon imageIcon = ImageIconPreloader.getIcon(iconPath);
		assertNotNull(imageIcon);
	}

	/**
	 * Tests the preloadIcon method with description
	 */
	@Test
	void testPreloadIconWithDescription()
	{
		String iconPath = "img/xmas/key.png";
		String description = "Key icon";
		ImageIconPreloader.loadIcon(iconPath, description);
		assertNotNull(ImageIconPreloader.getIcon(iconPath));
	}

	/**
	 * Tests the preloadIcons method to ensure multiple icons are added to the cache
	 */
	@Test
	void testPreloadIcons()
	{
		String[] iconPaths = { "img/xmas/stars.png", "img/xmas/key.png" };
		ImageIconPreloader.loadIcons(iconPaths);
		for (String iconPath : iconPaths)
		{
			assertNotNull(ImageIconPreloader.getIcon(iconPath));
		}
	}

	/**
	 * Tests retrieving a non-existent icon from the cache
	 */
	@Test
	void testGetIconNotFound()
	{
		assertNull(ImageIconPreloader.getIcon("non/existent/icon.png"));
	}

	/**
	 * Parameterized test for preloadIcon with different paths
	 *
	 * @param iconPath
	 *            the path to the icon
	 */
	@ParameterizedTest
	@CsvSource({ "img/xmas/stars.png", "img/xmas/key.png", "img/xmas/bell.png",
			"img/xmas/greendices.png" })
	void testPreloadIconParameterized(String iconPath)
	{
		ImageIconPreloader.loadIcon(iconPath);
		assertNotNull(ImageIconPreloader.getIcon(iconPath));
	}
}
