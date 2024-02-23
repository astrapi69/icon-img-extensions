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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.awt.Color;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import io.github.astrapi69.color.model.HsbModel;
import io.github.astrapi69.color.model.RgbModel;


/**
 * Test class for the class {@link ColorExtensions}
 */
class ColorExtensionsTest
{

	/**
	 * Test method for {@link ColorExtensions#toColor(HsbModel)}
	 */
	@Test
	void toColorWithHsbModel()
	{
		int red;
		int green;
		int blue;
		float hue;
		float saturation;
		float brightness;
		HsbModel hsbModel;
		Color actual;
		Color expected;

		red = 51;
		blue = 153;
		green = 102;
		hue = 0.5833333f;
		saturation = 0.6666667f;
		brightness = 0.6f;

		hsbModel = HsbModel.builder().hue(hue).saturation(saturation).brightness(brightness)
			.build();

		actual = ColorExtensions.toColor(hsbModel);
		assertNotNull(actual);
		expected = new Color(red, green, blue);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link ColorExtensions#toColor(RgbModel)}
	 */
	@Test
	void toColorWithRgbModel()
	{
		int red;
		int green;
		int blue;
		RgbModel rgbModel;
		Color actual;
		Color expected;

		red = 51;
		blue = 153;
		green = 102;

		rgbModel = RgbModel.builder().red(red).blue(blue).green(green).build();

		actual = ColorExtensions.toColor(rgbModel);
		assertNotNull(actual);
		expected = new Color(red, green, blue);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link ColorExtensions#toRGB(HsbModel)}
	 */
	@Test
	void toRGB()
	{
		int red;
		int green;
		int blue;
		float hue;
		float saturation;
		float brightness;
		HsbModel hsbModel;
		RgbModel actual;
		RgbModel expected;

		red = 51;
		blue = 153;
		green = 102;
		hue = 0.5833333f;
		saturation = 0.6666667f;
		brightness = 0.6f;

		hsbModel = HsbModel.builder().hue(hue).saturation(saturation).brightness(brightness)
			.build();

		actual = ColorExtensions.toRGB(hsbModel);
		assertNotNull(actual);

		expected = RgbModel.builder().red(red).blue(blue).green(green).build();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link ColorExtensions#toHSB(RgbModel)}
	 */
	@Test
	void toHSB()
	{
		int red;
		int green;
		int blue;
		float hue;
		float saturation;
		float brightness;
		RgbModel rgbModel;
		HsbModel actual;
		HsbModel expected;

		red = 51;
		blue = 153;
		green = 102;
		hue = 0.5833333f;
		saturation = 0.6666667f;
		brightness = 0.6f;

		rgbModel = RgbModel.builder().red(red).blue(blue).green(green).build();

		actual = ColorExtensions.toHSB(rgbModel);
		assertNotNull(actual);
		expected = HsbModel.builder().hue(hue).saturation(saturation).brightness(brightness)
			.build();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link ColorExtensions#toRgbModel(Color)}
	 */
	@Test
	void toRgbModel()
	{
		int red;
		int green;
		int blue;
		Color inputArgument;
		RgbModel actual;
		RgbModel expected;

		red = 51;
		blue = 153;
		green = 102;

		inputArgument = new Color(red, green, blue);

		actual = ColorExtensions.toRgbModel(inputArgument);
		assertNotNull(actual);

		expected = RgbModel.builder().red(red).blue(blue).green(green).build();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link ColorExtensions#toHsbModel(Color)}
	 */
	@Test
	void toHsbModel()
	{
		float hue;
		float saturation;
		float brightness;
		Color inputArgument;
		HsbModel actual;
		HsbModel expected;

		hue = 0.5833333f;
		saturation = 0.6666667f;
		brightness = 0.6f;

		inputArgument = Color.getHSBColor(hue, saturation, brightness);

		actual = ColorExtensions.toHsbModel(inputArgument);
		assertNotNull(actual);
		expected = HsbModel.builder().hue(hue).saturation(saturation).brightness(brightness)
			.build();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link ColorExtensions} with {@link BeanTester}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(ColorExtensions.class);
	}

}