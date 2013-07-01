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

/**
 * Dashed Line example.
 *
 * @see casmi.graphics.element.Line
 *
 * @author Y.Ban
 *
 */
public class DashedLineExample extends Applet {

    Line l1 = new Line(200, 200, 600, 400);
    Line l2 = new Line(200, 400, 600, 200);

    @Override
    public void setup() {
        setSize(800, 600);

        l1.setStrokeColor(ColorSet.WHITE);
        l2.setStrokeColor(ColorSet.WHITE);

        l1.setStrokeWidth(25);
        l2.setStrokeWidth(25);

        l1.setDashedLinePram(20, 10);
        l2.setDashedLinePram(10, 20);

        addObject(l1);
        addObject(l2);
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
        AppletRunner.run("casmi.graphics.element.DashedLineExample", "Dashed Line Example");
    }

}
