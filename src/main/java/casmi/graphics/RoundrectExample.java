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
import casmi.graphics.element.RoundRect;

/**
 * Example of Graphics.
 * 
 * @author K. Nishimura
 * 
 */
public class RoundrectExample extends Applet {

    RoundRect r1 = new RoundRect(10, 500, 700, 500, 200);
    RoundRect r2 = new RoundRect(30, 200, 700, 200, 400);
    RoundRect r3 = new RoundRect(10, 600, 200, 200, 100);

    public void setup() {
        setSize(1024, 768);

        r1.setFillColor(new RGBColor(0.3, 0.7, 0.3));
        r1.setStrokeColor(new RGBColor(0.4, 0.9, 0.4));
        r1.setStrokeWidth(3);

        r2.setFill(false);
        r2.setStrokeWidth(5);
        r2.setStrokeColor(new RGBColor(0.4, 0.3, 0.3));

        r3.setFillColor(new RGBColor(0.3, 0.3, 0.7));
        r3.setStrokeColor(new RGBColor(0.5, 0.5, 0.9));

        addObject(r1);
        addObject(r2);
        addObject(r3);
    }

    @Override
    public void update() {}

    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {}

    @Override
    public void keyEvent(KeyEvent e) {}

    public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.RoundrectExample", "RoundRect Example");
    }

}
