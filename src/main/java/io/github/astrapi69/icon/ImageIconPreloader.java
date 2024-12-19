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

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.swing.ImageIcon;

/**
 * The {@link ImageIconPreloader} class is responsible for preloading and caching tray icons This
 * ensures that icons are ready to be displayed as soon as the system tray is initialized, reducing
 * delays during application startup
 */
public class ImageIconPreloader
{

	/**
	 * A concurrent map to cache preloaded icons with their paths as keys
	 */
	private static final ConcurrentMap<String, ImageIcon> iconCache = new ConcurrentHashMap<>();

	/**
	 * Preloads a single icon asynchronously and adds it to the icon cache
	 *
	 * @param iconPath
	 *            the path to the icon to be preloaded
	 */
	public static void preloadIcon(String iconPath)
	{
		CompletableFuture.runAsync(() -> {
			loadIcon(iconPath);
		});
	}

	/**
	 * Loads a single icon and adds it to the icon cache
	 *
	 * @param iconPath
	 *            the path to the icon to be loaded
	 */
	public static void loadIcon(String iconPath)
	{
		ImageIcon imageIcon = ImageIconFactory.newImageIcon(iconPath);
		iconCache.put(iconPath, imageIcon);
	}


	/**
	 * Loads a single icon and adds it to the icon cache
	 *
	 * @param iconPath
	 *            the path to the icon to be loaded
	 * @param description
	 *            the textual description of the image
	 */
	public static void loadIcon(String iconPath, String description)
	{
		ImageIcon imageIcon = ImageIconFactory.newImageIcon(iconPath, description);
		iconCache.put(iconPath, imageIcon);
	}

	/**
	 * Preloads a single icon asynchronously and adds it to the icon cache
	 *
	 * @param iconPath
	 *            the path to the icon to be preloaded
	 * @param description
	 *            the textual description of the image
	 */
	public static void preloadIcon(String iconPath, String description)
	{
		CompletableFuture.runAsync(() -> {
			loadIcon(iconPath, description);
		});
	}

	/**
	 * Retrieves a preloaded icon from the cache
	 *
	 * @param iconPath
	 *            the path to the icon to be retrieved
	 * @return the preloaded {@link ImageIcon} or null if not found in the cache
	 */
	public static ImageIcon getIcon(String iconPath)
	{
		return iconCache.get(iconPath);
	}

	/**
	 * Preloads multiple icons asynchronously and adds them to the icon cache
	 *
	 * @param iconPaths
	 *            the paths to the icons to be preloaded
	 */
	public static void preloadIcons(String... iconPaths)
	{
		for (String iconPath : iconPaths)
		{
			preloadIcon(iconPath);
		}
	}

	/**
	 * Loads multiple icons and adds them to the icon cache
	 *
	 * @param iconPaths
	 *            the paths to the icons to be preloaded
	 */
	public static void loadIcons(String... iconPaths)
	{
		for (String iconPath : iconPaths)
		{
			loadIcon(iconPath);
		}
	}
}
