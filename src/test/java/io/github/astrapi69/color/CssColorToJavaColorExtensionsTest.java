package io.github.astrapi69.color;

import io.github.astrapi69.color.model.HsbModel;
import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;

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

		actual = CssColorToJavaColorExtensions.toColor(cssString);
		assertNotNull(actual);
		expected = new Color(red, green, blue);
		assertEquals(expected, actual);

		red = 255;
		blue = 204;
		green = 0;
		alpha = 80;
		cssString = "#ff000080";

		actual = CssColorToJavaColorExtensions.toColor(cssString);
		assertNotNull(actual);
		expected = new Color(red, green, blue, alpha);
		assertEquals(expected, actual);

	}
}