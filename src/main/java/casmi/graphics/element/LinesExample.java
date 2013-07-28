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
import casmi.graphics.color.Color;
import casmi.graphics.color.HSBColor;
import casmi.graphics.color.RGBColor;

/**
 * Multiple lines example.
 *
 * @see casmi.graphics.element.Lines
 *
 * @author Y. Ban
 */
public class LinesExample extends Applet {

    Lines l1, l2;
    Color c = new HSBColor(0.1, 1.0, 0.8);

    @Override
    public void setup() {
        setSize(800, 600);

        l1 = new Lines();
        l1.vertex(210, 120);
        l1.vertex(280, 115);
        l1.vertex(495, 390);
        l1.vertex(240, 345);
        l1.vertex(200, 445);
        l1.setStrokeColor(new RGBColor(0.4, 1.0, 0.4));

        l2 = new Lines();
        l2.vertex(310, 20);
        l2.vertex(380, 115);
        l2.vertex(695, 290);
        l2.vertex(440, 345);
        l2.vertex(200, 445);
        l2.setStrokeColor(c);
        l2.setStrokeWidth(5);

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
        AppletRunner.run("casmi.graphics.element.LinesExample", "Lines Example");
    }

}
