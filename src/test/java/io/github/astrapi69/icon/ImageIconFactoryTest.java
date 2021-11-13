package io.github.astrapi69.icon;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class ImageIconFactoryTest
{

	@Test
	@Disabled
	public void testNewImageIcon()
	{
		ImageIcon imageIcon = ImageIconFactory.newImageIcon("img/xmas/stars.png");
		assertNotNull(imageIcon);
	}
}