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
import casmi.graphics.color.ColorSet;
import casmi.graphics.color.RGBColor;

/**
 * Circle example.
 *
 * @see casmi.graphics.element.Circle
 *
 * @author Y.Ban
 */
public class CircleExample extends Applet {

    Circle circle = new Circle(80);

    @Override
    public void setup() {
        setSize(800, 600);

        circle.setFillColor(new RGBColor(0.3, 0.7, 0.3));
        circle.setStrokeColor(ColorSet.LIGHT_CORAL);
        circle.setStrokeWidth(3);
        circle.setPosition(400,300);
        addObject(circle);
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
        AppletRunner.run("casmi.graphics.element.CircleExample", "Circle Example");
    }

}
