package io.github.astrapi69.color;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * The class {@link HsbModel} is the data model for the representation of the HSB. HSB stands for
 * Hue, Saturation, and Brightness (sometimes also referred to as Brightness is termed as Value,
 * making it HSV—Hue, Saturation, Value). It's a color model used to describe and manipulate colors
 * in a way that is more aligned with human perception of color
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HsbModel
{
	/**
	 * The hue represents the color itself, the aspect of color which is named or described as in
	 * "red", "blue", or "yellow". Hue is measured as a location on a color wheel, expressed as a
	 * degree between 0° and 360°. For instance, 0° represents red, 120° represents green, and 240°
	 * represents blue.
	 */
	float hue;

	/**
	 * The saturation refers to the intensity or purity of the color, representing how much gray is
	 * in the color. A fully saturated color (100%) has no gray, making it the purest form of that
	 * color. As saturation decreases, more gray is added, making the color appear more washed out
	 * or pale. At 0% saturation, the color would be completely gray.
	 */
	float saturation;

	/**
	 * The brightness (or Value): This indicates how light or dark the color is. Brightness ranges
	 * from 0% (completely black, no light) to 100% (fully bright, with the maximum amount of light
	 * the color can have). The higher the brightness, the lighter the color.
	 */
	float brightness;
}
