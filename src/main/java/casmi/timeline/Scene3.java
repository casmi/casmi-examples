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
import casmi.graphics.element.Bezier;
import casmi.graphics.element.Text;
import casmi.graphics.font.Font;

/**
 * Example of Timeline.
 * 
 * @author Y. Ban
 * 
 */

public class Scene3 extends Scene{

    Bezier b1 = new Bezier(100,200,200,400,300,300,400,200);
    Bezier b2 = new Bezier(400,200,500,100,700,300,800,600);
    Bezier b3 = new Bezier(300.0,300.0,-20.0, 800.0,800.0,-100.0,
                           300.0,600.0,-50.0, 700.0,500.0,-70.0);
    
    Font f = null;
    Text t;
	
	public Scene3(int id,double time){
		setId(id);
		setTime(time);
		setup();
	}
	
	
	public void setup(){
			b1.setFill(false);
	        b2.setFill(false);
	        b3.setFill(false);
	        b1.setStrokeColor(new Color(200, 80, 80));
	        b2.setStrokeColor(new Color(200, 80, 80));
	        b3.setStrokeColor(new Color(80, 80, 200));
	        b1.setStrokeWidth(3);
	        b2.setStrokeWidth(3);
	        b3.setStrokeWidth(3);
	        b3.setDetail(b3.getDetail()*2);
	        
	        f = new Font("San-Serif");
	        f.setSize(70);
	        t = new Text("Bezier", f, 750, 150);
	        t.setStrokeColor(Color.color(ColorSet.WHITE));
	        
	        addObject(b1);
	        addObject(b2);
	        addObject(b3);
	        addObject(t);
	        
	}
	
}
