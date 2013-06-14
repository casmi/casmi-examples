/*
 *   casmi examples
 *   http://casmi.github.com/
 *   Copyright (C) 2011, Xcoo, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package casmi.ui;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.Color;
import casmi.graphics.color.ColorSet;
import casmi.graphics.color.RGBColor;

/**
 * @author S. Yoshida
 *
 * @see casmi.ui.PopupMenu
 */
public class PopupMenuExample extends Applet {

	PopupMenu menu;

	Color color;
	static final Color DEFAULT_COLOR = new RGBColor(ColorSet.WHITE);

	@Override
	public void setup() {
		setSize(200, 200);

		color = DEFAULT_COLOR;

		menu = getPopupMenu();
		menu.addMenuItem("clear", "clearColor");
		menu.addSeparator();
		menu.addMenuItem("red",   "changeColor", new RGBColor(ColorSet.RED));
		menu.addMenuItem("green", "changeColor", new RGBColor(ColorSet.GREEN));
		menu.addMenuItem("blue",  "changeColor", new RGBColor(ColorSet.BLUE));
	}

	public void clearColor() {
		this.color = DEFAULT_COLOR;
	}

	public void changeColor(RGBColor color) {
		this.color = color;
	}

	@Override
	public void update() {
		setBackGroundColor(color);
	}

	@Override
    public void exit() {}

	@Override
	public void mouseEvent(MouseEvent e, MouseButton b) {
		if (b.equals(MouseButton.RIGHT))
			menu.show();
	}

	@Override
	public void keyEvent(KeyEvent e) {}

	public static void main(String[] args) {
		AppletRunner.run("casmi.PopupMenuExample", "PopupMenuExample");
	}
}