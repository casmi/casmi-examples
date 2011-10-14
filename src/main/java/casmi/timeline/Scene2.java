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
	}
	
	public void draw(Graphics g){
        g.render(t1);
        g.render(t2);
        g.render(t);
	}
}
