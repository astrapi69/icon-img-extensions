package io.github.astrapi69.color;

import io.github.astrapi69.color.model.HsbModel;

import java.awt.Color;
import java.util.regex.Pattern;

public class CssColorToJavaColorExtensions
{
	private static final Pattern hexRegex = Pattern.compile("#[\\dA-Fa-f]{6}");
	private static final Pattern hexRegexWithTransparency = Pattern.compile("#[\\dA-Fa-f]{8}");
	private static final Pattern rgbRegex = Pattern.compile("rgba?\\([^)]*\\)",
		Pattern.CASE_INSENSITIVE);
	private static final Pattern hlsRegex = Pattern.compile("hlsa?\\([^)]*\\)",
		Pattern.CASE_INSENSITIVE);


	public static Color toColor(String cssString)
	{
		if (hexRegexWithTransparency.matcher(cssString).matches())
			return toColorFromHexWithAlpha(cssString);
		if (hexRegex.matcher(cssString).matches())
			return toColorFromHex(cssString);
		if (rgbRegex.matcher(cssString).matches())
			return toColorFromRgb(cssString);
		if (hlsRegex.matcher(cssString).matches())
			return getRgbFromHsl(cssString);
		return null; // no match
	}

	private static Color getRgbFromHsl(String hslString)
	{
		String[] values = hslString.split("[\\s,()]");
		// values[0] is just "hsl" or "hsla"
		String hue = values[1];
		String sat = values[2];
		String light = values[3];
		String alpha = "1.0";
		if (values.length >= 5)
		{
			alpha = values[4];
		}
		int h = parseValue(hue, 360);
		double s = parsePercent(sat);
		double l = parsePercent(light);
		int a = parseAlpha(alpha);
		HsbModel hsbModel = HsbModel.builder().hue(h).saturation(Float.valueOf(s+"")).brightness(Float.valueOf(l+"")).build();
		Color color = ColorExtensions.toColor(hsbModel);
		return new Color(color.getRed(), color.getGreen(), color.getBlue(), a);
	}

	public static Color toColorFromHex(String hexString)
	{
		Color color = new Color(Integer.decode(hexString));
		return color;
	}

	private static Color toColorFromHexWithAlpha(String hexString)
	{
		String alphaAsString = hexString.substring(hexString.length() - 2);
		int alpha = Integer.parseInt(alphaAsString);
		String hexColor = hexString.substring(0, hexString.length() - 2);
		Color color = new Color(Integer.decode(hexColor));
		int alpha1 = parseAlpha(alphaAsString);
		return new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha1);
	}

	private static Color toColorFromRgb(String rgbString)
	{
		String[] values = rgbString.split("[\\s,()]");
		String red = values[1];
		String green = values[2];
		String blue = values[3];
		String alpha = "1.0";
		if (values.length >= 5)
		{
			alpha = values[4];
		}
		int alphaAsInt = Integer.parseInt(alpha);
		return new Color(parseValue(red, 255), parseValue(green, 255), parseValue(blue, 255), alphaAsInt);
	}

	private static int parseValue(String val, int max)
	{
		if (val.endsWith("%"))
		{
			return (int)(parsePercent(val) * max);
		}
		return Integer.parseInt(val);
	}

	private static double parsePercent(String perc)
	{
		return Integer.parseInt(perc.substring(0, perc.length() - 1)) / 100.0;
	}

	private static int parseAlpha(String alpha)
	{
		return (int)(Double.parseDouble(alpha) * 255);
	}
}
