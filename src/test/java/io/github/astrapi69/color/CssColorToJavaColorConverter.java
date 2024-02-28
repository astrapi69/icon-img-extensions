package io.github.astrapi69.color;

import java.awt.Color;
import java.util.Arrays;
import java.util.regex.Pattern;

public class CssColorToJavaColorConverter
{
	public static void main(String[] args)
	{
		System.out.println(Arrays.toString(getRGB("#ff00cc")));
		System.out.println(Arrays.toString(getRGB("#FF00CC")));
		System.out.println(Arrays.toString(getRGB("#ff000080")));
		System.out.println(Arrays.toString(getRGB("#FF00CC80")));
		System.out.println(Arrays.toString(getRGB("rgb(255,0,0)")));
		System.out.println(Arrays.toString(getRGB("rgba(255,0,0,0.5)")));
		System.out.println(Arrays.toString(getRGB("rgba(100%,0%,30%,0.5)")));
		System.out.println(Arrays.toString(getRGB("hsl(120, 60%, 70%)")));
		System.out.println(Arrays.toString(getRGB("hsla(120, 60%, 70%, 0.3)")));
	}

	private static final Pattern hexRegex = Pattern.compile("#[\\dA-Fa-f]{6}");
	private static final Pattern hexRegexWithTransparency = Pattern.compile("#[\\dA-Fa-f]{8}");
	private static final Pattern rgbRegex = Pattern.compile("rgba?\\([^)]*\\)",
		Pattern.CASE_INSENSITIVE);
	private static final Pattern hlsRegex = Pattern.compile("hlsa?\\([^)]*\\)",
		Pattern.CASE_INSENSITIVE);

	public static int[] getRGB(String cssString)
	{
		if (hexRegexWithTransparency.matcher(cssString).matches())
			return getRgbFromHexWithTransparency(cssString);
		if (hexRegex.matcher(cssString).matches())
			return getRgbFromHex(cssString);
		if (rgbRegex.matcher(cssString).matches())
			return getRgbFromRgb(cssString);
		if (hlsRegex.matcher(cssString).matches())
			return getRgbFromHsl(cssString);
		return null; // no match
	}

	private static int[] getRgbFromHex(String hexString)
	{
		Color color = new Color(Integer.decode(hexString));
		return new int[] { color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha() };
	}

	private static int[] getRgbFromHexWithTransparency(String hexString)
	{
		String alphaAsString = hexString.substring(hexString.length() - 2);
		int alpha = Integer.parseInt(alphaAsString);
		String hexColor = hexString.substring(0, hexString.length() - 2);
		Color color = new Color(Integer.decode(hexColor));
		return new int[] { color.getRed(), color.getGreen(), color.getBlue(), alpha };
	}

	private static int[] getRgbFromRgb(String rgbString)
	{
		String[] values = rgbString.split("[\\s,()]");
		// values[0] is just "rgb" or "rgba"
		String red = values[1];
		String green = values[2];
		String blue = values[3];
		String alpha = "1.0";
		if (values.length >= 5)
		{
			alpha = values[4];
		}
		return new int[] { parseValue(red, 255), parseValue(green, 255), parseValue(blue, 255),
				parseAlpha(alpha), };
	}

	private static int[] getRgbFromHsl(String hslString)
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
		return hslToRgb(h, s, l, a);
	}

	private static int[] hslToRgb(int h, double s, double l, int a)
	{
		// TODO Calculate me
		int r = 0;
		int g = 0;
		int b = 0;
		return new int[] { r, g, b, a };
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
