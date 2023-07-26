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
package io.github.astrapi69.swing.button;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.UIManager;

import org.junit.jupiter.api.Test;

/**
 * The unit test class for the class {@link IconButtonFactory}
 *
 * @author Asterios Raptis
 */
class IconButtonFactoryTest
{

	/**
	 * Test for method {{@link IconButtonFactory#newIconButton(Icon)}
	 */
	@Test
	void testNewIconButtonWithIcon()
	{
		JButton actual;
		Icon fileIcon;

		fileIcon = UIManager.getIcon("FileView.fileIcon");
		actual = IconButtonFactory.newIconButton(fileIcon);
		assertNotNull(actual);
	}

	/**
	 * Test for method {{@link IconButtonFactory#newIconButton(Icon, String)}
	 */
	@Test
	void testNewIconButtonWithIconAndToolTipText()
	{
		JButton actual;
		Icon fileIcon;
		String toolTipText;

		toolTipText = "a tool tip";
		fileIcon = UIManager.getIcon("FileView.fileIcon");
		actual = IconButtonFactory.newIconButton(fileIcon, toolTipText);
		assertNotNull(actual);
	}

	/**
	 * Test for method {{@link IconButtonFactory#newIconButton(String, String)}
	 */
	@Test
	void testNewIconButtonWithIconPathAsStringAndToolTipText()
	{
		JButton actual;
		String toolTipText;
		String relativeImagePath;

		relativeImagePath = "img/xmas/bell.png";

		toolTipText = "a tool tip";
		actual = IconButtonFactory.newIconButton(relativeImagePath, toolTipText);
		assertNotNull(actual);
	}

	/**
	 * Test for method {{@link IconButtonFactory#newIconButton(Icon, String, String)}
	 */
	@Test
	void testNewIconButtonWithIconAndToolTipTextAndText()
	{
		JButton actual;
		Icon fileIcon;
		String toolTipText;
		String text;

		toolTipText = "a tool tip";
		text = "Click me";
		fileIcon = UIManager.getIcon("FileView.fileIcon");
		actual = IconButtonFactory.newIconButton(fileIcon, toolTipText, text);
		assertNotNull(actual);
	}

	/**
	 * Test for method {{@link IconButtonFactory#newIconButtonWithText(Icon, String)}
	 */
	@Test
	void testNewIconButtonWithIconAndText()
	{
		JButton actual;
		Icon fileIcon;
		String text;

		text = "Click me";
		fileIcon = UIManager.getIcon("FileView.fileIcon");
		actual = IconButtonFactory.newIconButtonWithText(fileIcon, text);
		assertNotNull(actual);
	}

	/**
	 * Test for method {{@link IconButtonFactory#newIconButton(Icon, String, String, String)}
	 */
	@Test
	void testNewIconButtonWithIconAndToolTipTextAndTextAndActionCommand()
	{
		JButton actual;
		Icon fileIcon;
		String toolTipText;
		String text;
		String actionCommand;

		toolTipText = "a tool tip";
		text = "Click me";
		actionCommand = "Store";
		fileIcon = UIManager.getIcon("FileView.fileIcon");
		actual = IconButtonFactory.newIconButton(fileIcon, toolTipText, text, actionCommand);
		assertNotNull(actual);
	}
}