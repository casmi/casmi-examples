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

package casmi.graphics.element;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseStatus;
import casmi.graphics.color.RGBColor;

/**
 * Example of Graphics.
 *
 * @author K. Nishimura
 *
 */
public class TriangleExample extends Applet {

    Triangle t1 = new Triangle(200, 200, 400, 400, 600, 200);
    Triangle t2 = new Triangle(400, 600, 700, 300, 900, 600);

    @Override
    public void setup() {
        setSize(1024, 768);

        t1.setFillColor(new RGBColor(1.0, 1.0, 1.0));
        t1.setStroke(false);

        t2.setFillColor(new RGBColor(0.5, 0.8, 0.4));
        t2.setStrokeColor(new RGBColor(0.0, 0.4, 0.8));
        t2.setStrokeWidth(5);

        addObject(t1);
        addObject(t2);
    }

    @Override
	public void update() {}

    @Override
    public void exit() {}

	@Override
	public void mouseEvent(MouseStatus e, MouseButton b) {}

	@Override
	public void keyEvent(KeyEvent e) {}

	public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.element.TriangleExample", "Triangle Example");
    }

}
