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

package casmi.graphics.font;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseStatus;
import casmi.graphics.canvas.Canvas;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Text;

/**
 * Font example.
 * <p>
 * All available fonts are displayed.
 * You can scroll with up/down keys or mouse wheel rotation.
 * Press ESC key to quit the application.
 *
 * @author T. Takeuchi
 *
 * @see casmi.graphics.font.Font
 */
public class FontExample extends Applet {

    Canvas canvas = new Canvas();
    double bottom = 0;

    @Override
    public void setup() {
        setSize(300, 500);

        String[] fontnames = Font.getAvailableFontFamilyNames();

        int y = getHeight();

        for (String fontname : fontnames) {
            Font font = new Font(fontname, FontStyle.PLAIN, 16);

            Text text = new Text(fontname, font, 5, y);
            text.setStrokeColor(ColorSet.WHITE);

            canvas.add(text);

            y -= 20;
        }

        bottom = y;

        addCanvas(canvas);
    }

    @Override
	public void update() {}

    @Override
    public void exit() {}

    @Override
	public void mouseEvent(MouseStatus e, MouseButton b) {
        if (e == MouseStatus.WHEEL_ROTATED) {
            double newY = canvas.getY() + getMouseWheelRotation();

            if (newY < 0) {
                newY = 0;
            } else if (- bottom < newY) {
                newY = - bottom;
            }

            canvas.setY(newY);
        }
    }

	@Override
	public void keyEvent(KeyEvent e) {
	    if (e == KeyEvent.PRESSED) {
	        int keyCode = getKeyCode();
	        double newY = canvas.getY();

	        if (keyCode == java.awt.event.KeyEvent.VK_UP) {
	            newY -= 20;
	        } else if (keyCode == java.awt.event.KeyEvent.VK_DOWN) {
	            newY += 20;
	        } else if (keyCode == java.awt.event.KeyEvent.VK_ESCAPE) {
	            System.exit(0);
	        }

	        if (newY < 0) {
                newY = 0;
            } else if (- bottom < newY) {
                newY = - bottom;
            }

	        canvas.setY(newY);
	    }
	}

    public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.font.FontExample", "Font Example");
    }

}
