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

package casmi;

import static casmi.Applet.CursorMode.DEFAULT;
import static casmi.Applet.CursorMode.HAND;
import casmi.graphics.Graphics;
import casmi.graphics.color.Color;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Line;
import casmi.graphics.element.MouseOver;
import casmi.graphics.element.Rect;

/**
 * Example of cursor.
 * 
 * @author Y. Ban
 */
public class CursorExample extends Applet {

	Line l1 = new Line(200, 150, 600, 450);
	Line l2 = new Line(200, 450, 600, 150);
	Rect r  = new Rect(400, 300, 360, 270);
	MouseOver mo;

	@Override
	public void setup() {
		setSize(800, 600);
		
		l1.setStrokeColor(ColorSet.WHITE);
		l1.setStrokeWidth(25);
		
		l2.setStrokeColor(ColorSet.WHITE);
		l2.setStrokeWidth(25);

		r.setFillColor(new Color(100, 100));
		r.setStroke(false);
		mo = new MouseOver(r);
	}

	@Override
	public void draw(Graphics g) {
		g.render(l1);
		g.render(l2);
		g.render(r);

		if (mo.isMouseOver(getMouseX(), getMouseY())) {
			cursor(HAND);
		} else {
			cursor(DEFAULT);
		}
	}

	public static void main(String args[]) {
		AppletRunner.run("casmi.CursorExample", "Cursor Example");
	}
}
