/*
 *   casmi
 *   http://casmi.github.com/
 *   Copyright (C) 2011, Xcoo, Inc.
 *
 *  casmi is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package casmi.timeline;

import casmi.graphics.color.ColorSet;
import casmi.graphics.color.RGBColor;
import casmi.graphics.element.Text;
import casmi.graphics.element.Triangle;
import casmi.graphics.font.Font;

/**
 * Example of Timeline.
 * 
 * @author Y. Ban
 * 
 */
public class Scene2 extends Scene {

    Triangle t1 = new Triangle(200, 200, 400, 400, 600, 200);
    Triangle t2 = new Triangle(400, 600, 700, 300, 900, 600);

    Font f = null;
    Text t;

    public Scene2(int id, double time) {
        setId(id);
        setTime(time);
        setup();
    }

    @Override
    public void setup() {
        t1.setFillColor(new RGBColor(1.0, 1.0, 1.0));
        t1.setStroke(false);

        t2.setFillColor(new RGBColor(0.5, 0.8, 0.5));
        t2.setStrokeColor(new RGBColor(0.0, 0.5, 0.8));
        t2.setStrokeWidth(5);

        f = new Font("San-Serif");
        f.setSize(70);
        t = new Text("Triangle", f, 80, 520);
        t.setStrokeColor(ColorSet.WHITE);

        addObject(t1);
        addObject(t2);
        addObject(t);
    }
}
