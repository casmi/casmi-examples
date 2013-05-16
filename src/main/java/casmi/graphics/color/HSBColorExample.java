/*
 *   casmi examples
 *   http://casmi.github.io/
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

package casmi.graphics.color;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.element.Circle;

/**
 * HSB color example.
 *
 * @author T. Takeuchi
 *
 * @see casmi.graphics.color.HSBColor
 */
public class HSBColorExample extends Applet {

    Circle[] circles;
    HSBColor[] hsbColors;

    double saturation = 0.0;

    int count = 0;
    boolean reverse = false;

    @Override
    public void setup() {
        setSize(640, 480);

        circles = new Circle[36];
        hsbColors = new HSBColor[36];

        for (int i = 0; i < 36; ++i) {
            circles[i] = new Circle(15);
            hsbColors[i] = new HSBColor(i / 36.0, saturation, 1.0);

            circles[i].setFillColor(hsbColors[i]);

            circles[i].setX(getWidth() / 2.0 +
                200.0 * Math.cos(Math.toRadians((90.0 - i * (360.0 / 36.0)))));
            circles[i].setY(getHeight() / 2.0 +
                200.0 * Math.sin(Math.toRadians((90.0 - i * (360.0 / 36.0)))));

            addObject(circles[i]);
        }
    }

    @Override
    public void update() {
        if (count < 50) {
            saturation += reverse ? -0.02 : 0.02;

            for (HSBColor color : hsbColors)
                color.setSaturation(saturation);
        } else {
            reverse = !reverse;
            count = 0;
        }
        count++;
    }

    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {}

    @Override
    public void keyEvent(KeyEvent e) {}

    public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.color.HSBColorExample", "HSBColor Example");
    }
}
