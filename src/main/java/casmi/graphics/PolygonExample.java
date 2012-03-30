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
import casmi.graphics.element.Polygon;

/**
 * Example of Graphics.
 * 
 * @author Y. Ban
 * 
 */
public class PolygonExample extends Applet {

    Polygon polygon1, polygon2;

    @Override
    public void setup() {
        setSize(1024, 768);

        polygon1 = new Polygon();
        polygon1.vertex(210, 120);
        polygon1.vertex(280, 115);
        polygon1.vertex(495, 390);
        polygon1.vertex(240, 345);
        polygon1.vertex(200, 445);

        polygon2 = new Polygon();
        polygon2.vertex(310, 20);
        polygon2.vertex(380, 115);
        polygon2.vertex(695, 290);
        polygon2.vertex(440, 345);
        polygon2.vertex(200, 445);
        polygon2.setFill(false);
        polygon2.setStrokeColor(new RGBColor(0.8, 0.0, 0.4));
        polygon2.setStrokeWidth(7);

        addObject(polygon1);
        addObject(polygon2);
    }

    @Override
    public void update() {}
    
    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {}

    @Override
    public void keyEvent(KeyEvent e) {}

    public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.PolygonExample", "PolygonExample");
    }

}
