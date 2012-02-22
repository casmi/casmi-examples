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

import casmi.graphics.color.Color;
import casmi.graphics.color.ColorSet;
import casmi.graphics.color.RGBColor;
import casmi.graphics.element.Rect;
import casmi.graphics.element.Text;
import casmi.graphics.font.Font;

/**
 * Example of Timeline.
 * 
 * @author Y. Ban
 */
public class Scene1 extends Scene {

    Rect r1 = new Rect(500, 200);
    Rect r2 = new Rect(200, 400);
    Color c = new RGBColor(0.1, 0.4, 0.4);
    Font f = null;
    Text t;
	
	public Scene1(int id,double time) {
		setId(id);
		setTime(time);
		setup();
	}
	
	@Override
	public void setup() {
			r1.setFillColor(c);
	        r1.setStrokeColor(new RGBColor(0.4, 0.9, 0.4));
	        r1.setStrokeWidth(3);
	        r1.setPosition(500, 300);
	        
	        r2.setFill(false);
	        r2.setStrokeWidth(5);
	        r2.setStrokeColor(new RGBColor(0.7, 0.3, 0.3));
	        r2.setPosition(200, 300);
	        
	        addObject(r1);
	        addObject(r2);
	        
	        f = new Font("San-Serif");
	        f.setSize(70);
	        t = new Text("Rect", f, 700, 600);
	        t.setStrokeColor(ColorSet.WHITE);
	        
	        addObject(t);
	}
}
