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
import casmi.Keyboard;
import casmi.Mouse;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.ColorSet;

/**
 * Line example.
 *
 * @see casmi.graphics.element.Line
 *
 * @author K. Nishimura
 *
 */
public class LineExample extends Applet {

    Line l1 = new Line(200, 200, 600, 400);
    Line l2 = new Line(200, 400, 600, 200);

    @Override
    public void setup() {
        setSize(800, 600);

        l1.setStrokeColor(ColorSet.WHITE);
        l2.setStrokeColor(ColorSet.WHITE);

        l1.setStrokeWidth(25);
        l2.setStrokeWidth(25);

        addObject(l1);
        addObject(l2);
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
        AppletRunner.run("casmi.graphics.element.LineExample", "Line Example");
    }

}
