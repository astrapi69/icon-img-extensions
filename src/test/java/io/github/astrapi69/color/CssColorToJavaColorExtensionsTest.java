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
package io.github.astrapi69.color;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import io.github.astrapi69.collection.list.ListFactory;


/**
 * Test class for the class {@link CssColorToJavaColorExtensions}
 */
class CssColorToJavaColorExtensionsTest
{

	/**
	 * Test method for {@link CssColorToJavaColorExtensions#toColor(String)}
	 */
	@Test
	void toColor()
	{
		CssColorToJavaColorExtensionsTest.getTestCssStrings().stream().forEach(
			cssColor -> System.out.println(CssColorToJavaColorExtensions.toColor(cssColor)));
	}

	/**
	 * Test data
	 */
	public static List<String> getTestCssStrings()
	{
		List<String> cssColorStrings = ListFactory.newArrayList("#ff00cc", "#FF00CC", "#ff000080",
			"#FF00CC80", "rgb(255,0,0)", "rgba(255,0,0,0.5)", "rgba(100%,0%,30%,0.5)");
		return cssColorStrings;
	}

	/**
	 * Test method for {@link CssColorToJavaColorExtensions#toHexString(Color, boolean)}
	 */
	@Test
	void toHexString()
	{
		int red;
		int green;
		int blue;
		String hexString;
		String cssString;
		Color actual;
		Color expected;

		red = 255;
		blue = 204;
		green = 0;
		cssString = "#ff00cc";

		actual = CssColorToJavaColorExtensions.toColor(cssString);
		assertNotNull(actual);
		expected = new Color(red, green, blue);
		assertEquals(expected, actual);
		hexString = CssColorToJavaColorExtensions.toHexString(actual, false);
		assertEquals(cssString, hexString);
		hexString = CssColorToJavaColorExtensions.toHexString(actual, false, true);
		cssString = "#FF00CC";
		assertEquals(cssString, hexString);
	}


	/**
	 * Test method for {@link CssColorToJavaColorExtensions#toHexString(Color, boolean)}
	 */
	@Test
	void toHexString2()
	{
		int red;
		int green;
		int blue;
		int alpha;
		int actualAlpha;
		int expectedAlpha;
		String hexStringFromInt;
		String hexString;
		String cssString;
		Color actual;
		Color input;

		red = 128;
		blue = 128;
		green = 128;

		input = new Color(red, green, blue);

		hexStringFromInt = Integer.toHexString(input.getRGB());
		hexString = "#" + hexStringFromInt.substring(hexStringFromInt.length() - 6);
		actualAlpha = input.getAlpha();
		expectedAlpha = 255;
		assertEquals(expectedAlpha, actualAlpha);
		actual = CssColorToJavaColorExtensions.toColor(hexString);
		cssString = CssColorToJavaColorExtensions.toHexString(actual, false);
		assertEquals(hexString, cssString);

		alpha = 32;
		input = new Color(red, green, blue, alpha);

		hexStringFromInt = Integer.toHexString(input.getRGB());
		hexString = "#" + hexStringFromInt;
		actualAlpha = input.getAlpha();
		expectedAlpha = 32;
		assertEquals(expectedAlpha, actualAlpha);
		actual = CssColorToJavaColorExtensions.toColor(hexString);
		cssString = CssColorToJavaColorExtensions.toHexString(actual, true);
		assertEquals(hexString, cssString);
	}


	/**
	 * Test method for {@link CssColorToJavaColorExtensions#toColor(String)}
	 */
	@Test
	void toColorWithHsbModel()
	{
		int red;
		int green;
		int blue;
		int alpha;
		String cssString;
		Color actual;
		Color expected;

		red = 255;
		blue = 204;
		green = 0;
		cssString = "#ff00cc";

		actual = CssColorToJavaColorExtensions.toColor(cssString);
		assertNotNull(actual);
		expected = new Color(red, green, blue);
		assertEquals(expected, actual);

		red = 255;
		blue = 204;
		green = 0;
		cssString = "#FF00CC";

		expected = new Color(red, green, blue);
		actual = CssColorToJavaColorExtensions.toColor(cssString);
		assertNotNull(actual);
		assertEquals(expected, actual);

		red = 255;
		blue = 0;
		green = 0;
		cssString = "#ff0000";

		expected = new Color(red, green, blue);
		actual = CssColorToJavaColorExtensions.toColor(cssString);
		assertNotNull(actual);
		assertEquals(expected, actual);

		red = 255;
		blue = 0;
		green = 0;
		alpha = 128;
		cssString = "#ff000080";

		expected = new Color(red, green, blue, alpha);
		actual = CssColorToJavaColorExtensions.toColor(cssString);
		assertNotNull(actual);
		assertEquals(expected, actual);

		red = 255;
		blue = 204;
		green = 0;
		alpha = 128;
		cssString = "#FF00CC80";

		expected = new Color(red, green, blue, alpha);
		actual = CssColorToJavaColorExtensions.toColor(cssString);
		assertNotNull(actual);
		assertEquals(expected, actual);

		red = 255;
		blue = 0;
		green = 0;
		cssString = "rgb(255,0,0)";

		expected = new Color(red, green, blue);
		actual = CssColorToJavaColorExtensions.toColor(cssString);
		assertNotNull(actual);
		assertEquals(expected, actual);

		red = 255;
		blue = 0;
		green = 0;
		alpha = 127;
		cssString = "rgba(255,0,0,0.5)";

		expected = new Color(red, green, blue, alpha);
		actual = CssColorToJavaColorExtensions.toColor(cssString);
		assertNotNull(actual);
		assertEquals(expected, actual);

		red = 255;
		blue = 76;
		green = 0;
		alpha = 127;
		cssString = "rgba(100%,0%,30%,0.5)";

		expected = new Color(red, green, blue, alpha);
		actual = CssColorToJavaColorExtensions.toColor(cssString);
		assertNotNull(actual);
		assertEquals(expected, actual);

	}

	/**
	 * Test method for {@link CssColorToJavaColorExtensions} with {@link BeanTester}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(CssColorToJavaColorExtensions.class);
	}

}