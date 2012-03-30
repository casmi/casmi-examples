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

package casmi;

import casmi.graphics.color.HSBColor;
import casmi.graphics.element.Text;
import casmi.graphics.font.Font;
import casmi.util.Random;

/**
 * Simple keyboard example.
 * <p>
 * Press any key and show.
 * 
 * @author Y. Ban
 */
public class KeyboardSimpleExample extends Applet {

    Font f;
    Text t;

    @Override
    public void setup() {
        setSize(400, 400);
    }

    @Override
    public void update() {}

    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {
        if (e == MouseEvent.PRESSED && b == MouseButton.RIGHT)
            clearObject();
    }

    @Override
    public void keyEvent(KeyEvent e) {
        if (e == KeyEvent.PRESSED) {
            String s = "";
            f = new Font("Times New Roman");
            f.setSize(Random.random(10, 40));
            s += getKey();
            t = new Text(s, f);
            HSBColor c = new HSBColor(0.7, 0.8, 0.8);
            c.setHue((int)Random.random(0, 255) / 255.0);
            t.setStrokeColor(c);
            t.setPosition(Random.random(0, 400), Random.random(0, 400));
            addObject(t);
        }
    }

    public static void main(String[] args) {
        AppletRunner.run("casmi.KeyboardSimpleExample", "Simple Keyboard Example");
    }

}
