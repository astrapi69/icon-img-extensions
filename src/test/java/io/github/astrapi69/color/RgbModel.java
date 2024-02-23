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
 * The class {@link RgbModel} is the data model for the representation of the RGB. RGB stands for
 * Red, Green, and Blue, and it's a color model used in various devices and applications
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RgbModel
{
	/** the int value for the red color */
	int red;

	/** the int value for the green color */
	int green;

	/** the int value for the blue color */
	int blue;
}
