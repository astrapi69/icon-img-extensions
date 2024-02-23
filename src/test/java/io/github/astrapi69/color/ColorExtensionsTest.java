package io.github.astrapi69.color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;


/**
 * Test class for the class {@link ColorExtensions}
 */
class ColorExtensionsTest
{

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
	 * Test method for {@link ColorExtensions} with {@link BeanTester}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(ColorExtensions.class);
	}

}