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

package casmi.graphics.gradation;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.Keyboard;
import casmi.Mouse;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Bezier;
import casmi.graphics.element.Curve;
import casmi.graphics.element.Line;
import casmi.graphics.element.Lines;

/**
 * Bezier example.
 *
 * @see casmi.graphics.element.Bezier
 *
 * @author Y.Ban
 */
public class GradationBezierExample extends Applet {

    Line l1 = new Line(200, 200, 600, 400);
    Lines l2;
    Bezier b3 = new Bezier(100, 200, -20, 700, 400, -100, 300, 600, -50, 700, 500, -70);
    Curve curve = new Curve(200, 100, 300, 400, 100, 200, 200, 0);

    @Override
    public void setup() {
        setSize(800, 600);

        l1.setCornerColor(1, ColorSet.AZURE);
        l1.setCornerColor(0, ColorSet.BLUE_VIOLET);

        l2 = new Lines();
        l2.vertex(310, 20);
        l2.vertex(380, 115);
        l2.vertex(695, 290);
        l2.vertex(440, 345);
        l2.vertex(200, 445);
        l2.setStartCornerColor(ColorSet.YELLOW_GREEN);
        l2.setEndCornerColor(ColorSet.DARK_MAGENTA);
        l2.setStrokeWidth(2);

        b3.setFill(false);
        b3.setAnchorColor(0, ColorSet.RED);
        b3.setAnchorColor(1, ColorSet.LIGHT_GREEN);
        b3.setStrokeWidth(5);

        curve.setFill(false);
        curve.setAnchorColor(0, ColorSet.BLUE);
        curve.setAnchorColor(1, ColorSet.YELLOW);

        addObject(l1);
        addObject(l2);
        addObject(b3);
        addObject(curve);
    }

    @Override
	public void update() {}

    @Override
    public void exit() {}

    @Override
	public void mouseEvent(MouseEvent event, MouseButton button, Mouse mouse) {}

	@Override
	public void keyEvent(KeyEvent event, Keyboard keybaord) {}

    public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.gradation.GradationBezierExample", "GradationBezierExample");
    }

}
