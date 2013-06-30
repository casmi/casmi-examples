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
import casmi.graphics.color.RGBColor;
import casmi.graphics.element.Box;
import casmi.graphics.object.Camera;
import casmi.graphics.object.Perspective;

/**
 * Box example.
 *
 * @see casmi.graphics.element.Box
 *
 * @author Y. BAN
 */
public class BoxExample extends Applet {

    Box b1 = new Box(1.0);
    Box b2 = new Box(0.8, 1.0, 1.2);

    double rot = 0.0;

    Perspective p;
    Camera c;

    @Override
    public void setup() {
        setSize(800, 600);

        b1.setStrokeWidth(1.0);
        b1.setFillColor(new RGBColor(0.4, 0.4, 0.4));
        b1.setStrokeColor(new RGBColor(1.0, 1.0, 1.0));
        b1.setRotation(rot, 1, 3, 5);

        b2.setStrokeWidth(1.0);
        b2.setFillColor(new RGBColor(0.0, 0.0, 0.4, 0.5));
        b2.setStrokeColor(new RGBColor(0.0, 0.0, 1.0));
        b2.setPosition(0, -1, 1);

        p = new Perspective(30.0, (double)getWidth() / (double)getHeight(), 1.0, 100.0);
        c = new Camera(3.0, 4.0, 5.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);

        setPerspective(p);
        setCamera(c);

        addObject(b1);
        addObject(b2);
    }

    @Override
    public void update() {
        rot += 0.1;
        b1.setRotation(rot, 1, 3, 5);
    }

    @Override
    public void exit() {}

    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {}

    @Override
    public void keyEvent(KeyEvent e) {}

    public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.BoxExample", "Box Example");
    }
}
