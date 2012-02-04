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

import casmi.graphics.Graphics;
import casmi.graphics.color.Color;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Text;
import casmi.graphics.element.Triangle;
import casmi.graphics.font.Font;

/**
 * Example of Timeline.
 * 
 * @author Y. Ban
 * 
 */

public class Scene2 extends Scene{


    Triangle t1 = new Triangle(200, 200, 400, 400, 600, 200);
    Triangle t2 = new Triangle(400, 600, 700, 300, 900, 600);
    
    Font f = null;
    Text t;
	
	public Scene2(int id,double time){
		setId(id);
		setTime(time);
		setup();
	}
	
	public void setup(){
        t1.setFillColor(new Color(255, 255, 255));
        t1.setStroke(false);

        t2.setFillColor(new Color(120, 200, 100));
        t2.setStrokeColor(new Color(0, 100, 200));
        t2.setStrokeWidth(5);
        
        f = new Font("San-Serif");
        f.setSize(70);
        t = new Text("Triangle", f, 80, 520);
        t.setStrokeColor(Color.color(ColorSet.WHITE));
        
        addObject(t1);
        addObject(t2);
        addObject(t);
	}
	
}
