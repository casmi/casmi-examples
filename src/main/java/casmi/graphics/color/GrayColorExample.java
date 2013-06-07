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

package casmi.graphics.color;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.element.Circle;

/**
 * GrayColor class example.
 *
 * @author T. Takeuchi
 *
 * @see casmi.graphics.color.Color
 * @see casmi.graphics.color.GrayColor
 */
public class GrayColorExample extends Applet {

    @Override
    public void setup() {
        setSize(640, 480);

        for (int i = 1; i <= 10; ++i) {
            Circle circle = new Circle(getWidth() / 2 + 55 * (i - 6), getHeight() / 2, 23);
            circle.setFillColor(new GrayColor(0.1 * i));
            addObject(circle);
        }
    }

    @Override
    public void update() {}

    @Override
    public void exit() {}

    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {}

    @Override
    public void keyEvent(KeyEvent e) {}

    public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.color.GrayColorExample", "GrayColor Example");
    }

}
