package io.github.astrapi69.icon;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.swing.JLabel;

import org.junit.jupiter.api.Test;

public class StringIconTest
{

	/**
	 * Test for constructor of {{@link StringIcon}
	 */
	@Test
	public void testNewStringIcon()
	{
		JLabel label = new JLabel();
		StringIcon actual = new StringIcon(label, "foo");
		assertNotNull(actual);
	}
}
