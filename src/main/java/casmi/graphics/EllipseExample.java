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
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.ColorSet;
import casmi.graphics.color.RGBColor;
import casmi.graphics.element.Ellipse;

/**
 * Ellipse example.
 *
 * @see casmi.graphics.element.Ellipse
 *
 * @author K. Nishimura
 */
public class EllipseExample extends Applet {

    Ellipse el = new Ellipse(400, 300, 300, 160);

    @Override
    public void setup() {
        setSize(800, 600);

        el.setFillColor(new RGBColor(0.3, 0.7, 0.3));
        el.setStrokeColor(ColorSet.LIGHT_CORAL);
        el.setStrokeWidth(3);

        addObject(el);
    }

	@Override
	public void mouseEvent(MouseEvent e, MouseButton b) {}

	@Override
	public void keyEvent(KeyEvent e) {}

	@Override
	public void update() {}

    @Override
    public void exit() {}

	public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.EllipseExample", "Ellipse Example");
    }

}
