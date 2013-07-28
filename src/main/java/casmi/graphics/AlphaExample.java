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

package casmi.graphics;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.Keyboard;
import casmi.Mouse;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.RGBColor;
import casmi.graphics.element.Rect;

/**
 * Alpha example.
 *
 * @see casmi.graphics.Graphics
 * @see casmi.graphics.color.Color
 *
 * @author Y. Ban
 */
public class AlphaExample extends Applet {

    Rect r1 = new Rect(300, 300);
    Rect r2 = new Rect(300, 300);

    @Override
    public void setup() {
        setSize(800, 600);

        r1.setStroke(false);
        r1.setFillColor(new RGBColor(0.4, 0.95, 0.4, 0.6));
        r1.setPosition(350, 250);

        r2.setStroke(false);
        r2.setFillColor(new RGBColor(0.7, 0.1, 0.1, 0.6));
        r2.setPosition(450, 350);

        addObject(r1);
        addObject(r2);
    }

    @Override
    public void update() {}

    @Override
    public void exit() {}

	@Override
	public void mouseEvent(MouseEvent event, MouseButton button, Mouse mouse) {}

	@Override
	public void keyEvent(KeyEvent event, Keyboard keyboard) {}

	public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.AlphaExample", "Alpha Example");
    }
}
