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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
public class PointExample extends Applet {

    int numpoint = 1000;
    List<Point> points = new ArrayList<Point>();
    Random rnd = new Random();

    @Override
    public void setup() {
        setSize(800, 600);

        for (int i = 0; i < numpoint; i++) {
            Point p = new Point(150.0 + rnd.nextInt(500), 50.0 + rnd.nextInt(500));
            p.setStrokeColor(new RGBColor(1.0, 1.0, 1.0));

            points.add(p);
            addObject(p);
        }
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
        AppletRunner.run("casmi.graphics.element.PointExample", "PointExample");
    }

}
