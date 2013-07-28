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
import casmi.graphics.color.RGBColor;

/**
 * Example of Graphics.
 *
 * @author K. Nishimura
 *
 */
public class SphereExample extends Applet {

    Sphere s = new Sphere(300.0);

    double rot = 90.0;

    @Override
    public void setup() {
        setSize(1024, 768);

        s.setFill(false);
        s.setStrokeColor(new RGBColor(0.4, 0.4, 0.8));
        s.setStrokeWidth(4);

        s.setPosition(512.0, 430.0, 100.0);

        addObject(s);
    }

    @Override
    public void update() {
        rot += 0.1;
        s.setRotation(rot, rot * 3, rot * 5);
    }

    @Override
    public void exit() {}

    @Override
    public void mouseEvent(MouseEvent event, MouseButton button, Mouse mouse) {}

    @Override
    public void keyEvent(KeyEvent event, Keyboard keyboard) {}

    public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.element.SphereExample", "Sphere Example");
    }

}
