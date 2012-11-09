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

package casmi.timeline;

import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.ColorSet;
import casmi.graphics.color.RGBColor;
import casmi.graphics.element.Bezier;
import casmi.graphics.element.Text;
import casmi.graphics.font.Font;

/**
 * Example of Timeline.
 * 
 * @author Y. Ban
 * 
 */
public class Scene3 extends Scene {

    Bezier b1 = new Bezier(100, 200, 
        200, 400, 
        300, 300, 
        400, 200);
    Bezier b2 = new Bezier(400, 200, 
        500, 100, 
        700, 300, 
        800, 600);
    Bezier b3 = new Bezier(300.0, 300.0, -20.0,
        800.0, 800.0, -100.0,
        300.0, 600.0, -50.0,
        700.0, 500.0, -70.0);

    Font f = null;
    Text t;

    public Scene3(String id) {
        this(id, 0);
    }

    public Scene3(String id, double time) {
        super(id, time);
        b1.setFill(false);
        b2.setFill(false);
        b3.setFill(false);
        b1.setStrokeColor(new RGBColor(0.8, 0.3, 0.3));
        b2.setStrokeColor(new RGBColor(0.8, 0.3, 0.3));
        b3.setStrokeColor(new RGBColor(0.3, 0.3, 0.8));
        b1.setStrokeWidth(3);
        b2.setStrokeWidth(3);
        b3.setStrokeWidth(3);
        b3.setDetail(b3.getDetail() * 2);

        f = new Font("San-Serif");
        f.setSize(70);
        t = new Text("Bezier", f, 750, 150);
        t.setStrokeColor(ColorSet.WHITE);

        addObject(b1);
        addObject(b2);
        addObject(b3);
        addObject(t);
    }

    @Override
    public void update() {}

    @Override
    public void keyEvent(KeyEvent e) {
        switch (e) {
        case PRESSED:
            if (getKey() == 'b')
                goNextScene("Top", DissolveMode.BLACK, 3);
            break;
        }
    }


    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {}
}
