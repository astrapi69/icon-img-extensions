package io.github.astrapi69.color;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import io.github.astrapi69.color.model.HsbModel;

class CssColorToJavaColorExtensionsTest
{

	/**
	 * Test method for {@link CssColorToJavaColorExtensions#toHexString(Color, boolean)}
	 */
	@Test
	void toHexString()
	{
		int red;
		int green;
		int blue;
		int alpha;
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
		hexString = CssColorToJavaColorExtensions.toHexString(actual, false);
		assertEquals(cssString, hexString);

		Color your_color = new Color(128, 128, 128);

		String buf = Integer.toHexString(your_color.getRGB());
		String hex = "#" + buf.substring(buf.length() - 6);
		int alpha1 = your_color.getAlpha();
		assertEquals(255, alpha1);
		Color newColor = CssColorToJavaColorExtensions.toColor(hex);
		String hexString1 = CssColorToJavaColorExtensions.toHexString(newColor, false);
		assertEquals(hex, hexString1);

		your_color = new Color(128, 128, 128, 32);
		buf = Integer.toHexString(your_color.getRGB());
		hex = "#" + buf;
		alpha1 = your_color.getAlpha();
		assertEquals(32, alpha1);
		newColor = CssColorToJavaColorExtensions.toColor(hex);
		hexString1 = CssColorToJavaColorExtensions.toHexString(newColor, true);
		assertEquals(hex, hexString1);
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
		String hexString;
		String cssString;
		Color actual;
		Color input;

		red = 128;
		blue = 128;
		green = 128;

		input = new Color(red, green, blue);

		String buf = Integer.toHexString(input.getRGB());
		hexString = "#" + buf.substring(buf.length() - 6);
		actualAlpha = input.getAlpha();
		expectedAlpha = 255;
		assertEquals(expectedAlpha, actualAlpha);
		actual = CssColorToJavaColorExtensions.toColor(hexString);
		cssString = CssColorToJavaColorExtensions.toHexString(actual, false);
		assertEquals(hexString, cssString);

		alpha = 32;
		input = new Color(red, green, blue, alpha);

		buf = Integer.toHexString(input.getRGB());
		hexString = "#" + buf;
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

	Color toColor(int i)
	{
		final int a = (i >> 24) & 0xFF;
		final int r = (i >> 16) & 0xFF;
		final int g = (i >> 8) & 0xFF;
		final int b = i & 0xFF;
		return new Color(r, g, b, a);
	}
}