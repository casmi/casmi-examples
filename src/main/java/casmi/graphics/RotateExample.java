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
import casmi.MouseStatus;
import casmi.graphics.color.HSBColor;
import casmi.graphics.element.Bezier;

/**
 * Example of rotation.
 *
 * @author K. Nishimura, Y. Ban
 */
public class RotateExample extends Applet {

    Bezier b1 = new Bezier(0.0,   0.0,   0.0,
                           400.0, 400.0, -30.0,
                           500.0, 600.0, -10.0,
                           400.0, 100.0, -20.0);
    HSBColor c = new HSBColor(0.0, 0.9, 0.8);
    int r = 0;

    @Override
    public void setup() {
        setSize(1024, 768);

        b1.setFill(false);
        b1.setStrokeColor(c);
        b1.setStrokeWidth(1);

        b1.setPosition(getWidth() / 2.0, 100.0);

        for (int i = 0; i < 37; i++) {
        	Bezier b = (Bezier) b1.clone();
            addObject(b);
            b.setRotation(5 * i);
        }
    }

    @Override
    public void update() {
        c.setHue(r / 360.0);
        r++;
        if (r >= 360)
            r = 0;

        b1.setNode(1, 400 + 200 * Math.sin(r / 180.0 * Math.PI), 400 - 200 * Math.sin(r / 180.0 * Math.PI), -30);
        b1.setNode(3, 400.0 - 100 * Math.cos(r / 180.0 * Math.PI), 100.0 + 100 * Math.cos(r / 180.0 * Math.PI), -20.0);
    }

    @Override
    public void exit() {
    }

    @Override
    public void mouseEvent(MouseStatus e, MouseButton b) {}

    @Override
    public void keyEvent(KeyEvent e) {}

    public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.RotateExample", "Rotation Example");
    }
}