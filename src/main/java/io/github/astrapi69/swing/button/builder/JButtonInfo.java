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
package io.github.astrapi69.swing.button.builder;

import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

/**
 * The class {@link JButtonInfo} is the data model for the creation of {@link JButton} objects
 */
@Data
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JButtonInfo
{
	String text;
	Icon icon;
	String toolTipText;
	Integer mnemonic;
	ActionListener actionListener;
	String name;
	boolean selected;
	Action action;
	String actionCommand;

	public JButton toJButton()
	{
		JButton button = new JButton();
		setFields(button);
		return button;
	}

	private void setFields(JButton button)
	{
		button.setSelected(selected);
		if (action != null)
		{
			button.setAction(action);
		}
		if (actionCommand != null)
		{
			button.setActionCommand(actionCommand);
		}
		if (text != null)
		{
			button.setText(text);
		}
		if (icon != null)
		{
			button.setIcon(icon);
		}
		if (toolTipText != null)
		{
			button.setToolTipText(toolTipText);
		}
		if (mnemonic != null)
		{
			button.setMnemonic(mnemonic);
		}
		if (actionListener != null)
		{
			button.addActionListener(actionListener);
		}
		if (name != null)
		{
			button.setName(name);
		}
	}
}
