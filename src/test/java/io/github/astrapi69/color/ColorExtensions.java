package io.github.astrapi69.color;

import java.awt.Color;

import lombok.NonNull;

/**
 * The class {@link ColorExtensions} provides extension methods for operations with {@link Color}
 * objects
 */
public class ColorExtensions
{

	/**
	 * Converts the given {@link Color} object to a {@link RgbModel} object
	 *
	 * @param color
	 *            the color
	 * @return the new {@link RgbModel} object
	 */
	public static RgbModel toRgbModel(@NonNull final Color color)
	{
		return RgbModel.builder().red(color.getRed()).green(color.getGreen()).blue(color.getBlue())
			.build();
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
	 * Converts the given {@link HsbModel} object to a {@link RgbModel} object
	 *
	 * @param hsbModel
	 *            the HSB model the contains the values
	 * @return the new {@link RgbModel} object
	 */
	public static RgbModel toRGB(@NonNull final HsbModel hsbModel)
	{
		int rgb = Color.HSBtoRGB(hsbModel.getHue(), hsbModel.getSaturation(),
			hsbModel.getBrightness());
		return RgbModel.builder().red((rgb >> 16) & 0xFF).green((rgb >> 8) & 0xFF).blue(rgb & 0xFF)
			.build();
	}

	/**
	 * Converts the given {@link RgbModel} object to a {@link HsbModel} object
	 *
	 * @param rgbModel
	 *            the HSB model the contains the values
	 * @return the new {@link HsbModel} object
	 */
	public static HsbModel toHSB(@NonNull final RgbModel rgbModel)
	{

		float[] hsb = Color.RGBtoHSB(rgbModel.getRed(), rgbModel.getGreen(), rgbModel.getBlue(),
			null);
		return HsbModel.builder().hue(hsb[0]).saturation(hsb[1]).brightness(hsb[2]).build();
	}

}
