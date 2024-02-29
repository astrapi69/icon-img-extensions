package io.github.astrapi69.color;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import io.github.astrapi69.color.model.HsbModel;

class CssColorToJavaColorExtensionsTest
{

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
}