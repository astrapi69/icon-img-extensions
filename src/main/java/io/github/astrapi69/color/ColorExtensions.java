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

import java.awt.Color;

import io.github.astrapi69.color.model.HsbModel;
import io.github.astrapi69.color.model.RgbIntegerModel;
import lombok.NonNull;

/**
 * The class {@link ColorExtensions} provides extension methods for operations with {@link Color}
 * objects
 */
public class ColorExtensions
{

	/**
	 * Converts the given {@link Color} object to a {@link RgbIntegerModel} object
	 *
	 * @param color
	 *            the color
	 * @return the new {@link RgbIntegerModel} object
	 */
	public static RgbIntegerModel toRgbModel(@NonNull final Color color)
	{
		return RgbIntegerModel.builder().red(color.getRed()).green(color.getGreen())
			.blue(color.getBlue()).build();
	}

	/**
	 * Converts the given {@link Color} object to a {@link HsbModel} object
	 *
	 * @param color
	 *            the color
	 * @return the new {@link HsbModel} object
	 */
	public static HsbModel toHsbModel(@NonNull final Color color)
	{
		return toHSB(toRgbModel(color));
	}

	/**
	 * Converts the given {@link HsbModel} object to a {@link Color} object
	 *
	 * @param hsbModel
	 *            the HSB model the contains the values
	 * @return the new {@link Color} object
	 */
	public static Color toColor(@NonNull final HsbModel hsbModel)
	{
		return Color.getHSBColor(hsbModel.getHue(), hsbModel.getSaturation(),
			hsbModel.getBrightness());
	}

	/**
	 * Converts the given {@link RgbIntegerModel} object to a {@link Color} object
	 *
	 * @param rgbModel
	 *            the HSB model the contains the values
	 * @return the new {@link Color} object
	 */
	public static Color toColor(@NonNull final RgbIntegerModel rgbModel)
	{
		return new Color(rgbModel.getRed(), rgbModel.getGreen(), rgbModel.getBlue());
	}

	/**
	 * Converts the given {@link HsbModel} object to a {@link RgbIntegerModel} object
	 *
	 * @param hsbModel
	 *            the HSB model the contains the values
	 * @return the new {@link RgbIntegerModel} object
	 */
	public static RgbIntegerModel toRGB(@NonNull final HsbModel hsbModel)
	{
		int rgb = Color.HSBtoRGB(hsbModel.getHue(), hsbModel.getSaturation(),
			hsbModel.getBrightness());
		return RgbIntegerModel.builder().red((rgb >> 16) & 0xFF).green((rgb >> 8) & 0xFF)
			.blue(rgb & 0xFF).build();
	}

	/**
	 * Converts the given {@link RgbIntegerModel} object to a {@link HsbModel} object
	 *
	 * @param rgbModel
	 *            the HSB model the contains the values
	 * @return the new {@link HsbModel} object
	 */
	public static HsbModel toHSB(@NonNull final RgbIntegerModel rgbModel)
	{

		float[] hsb = Color.RGBtoHSB(rgbModel.getRed(), rgbModel.getGreen(), rgbModel.getBlue(),
			null);
		return HsbModel.builder().hue(hsb[0]).saturation(hsb[1]).brightness(hsb[2]).build();
	}

}
