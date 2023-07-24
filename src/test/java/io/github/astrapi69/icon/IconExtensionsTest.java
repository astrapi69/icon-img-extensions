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
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import io.github.astrapi69.file.delete.DeleteFileExtensions;
import io.github.astrapi69.file.search.PathFinder;

/**
 * Test class for the class {@link IconExtensions}
 */
class IconExtensionsTest
{

	/**
	 * Test method for {@link IconExtensions#toImage(Icon)}
	 */
	@Test
	void toImage()
	{
		Icon fileIcon = UIManager.getIcon("FileView.fileIcon");
		Image image = IconExtensions.toImage(fileIcon);
		assertNotNull(image);
	}

	/**
	 * Test method for {@link IconExtensions#storeIcon(Icon, String, File)}
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred
	 */
	@Test
	@Disabled("because this test case fails on github actions. Locally it runs successfully.")
	void storeIcon() throws IOException
	{
		final File imgDir = new File(PathFinder.getSrcTestResourcesDir(), "img");

		File xmas = new File(imgDir, "xmas");
		File outputFile = new File(xmas, "fileView.png");
		Icon fileIcon = UIManager.getIcon("FileView.fileIcon");
		boolean actual = IconExtensions.storeIcon(fileIcon, "png", outputFile);
		assertTrue(actual);
		assertTrue(outputFile.exists());
		DeleteFileExtensions.delete(outputFile);

	}

}