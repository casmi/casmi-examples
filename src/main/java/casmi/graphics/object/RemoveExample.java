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


package casmi.graphics.object;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Element;
import casmi.graphics.element.Ellipse;
import casmi.graphics.element.MouseOverCallback;
import casmi.graphics.element.Rect;
import casmi.graphics.element.Triangle;
import casmi.graphics.group.Group;

/**
 * Object example.
 * 
 * @author Y. Ban
 */

class TriangleGroups extends Group {

    Triangle t1, t2;

    public TriangleGroups() {
        setup();
    }

    @Override
    public void setup() {
        t1 = new Triangle(100, 100, 200, 100, 150, 150);
        t2 = new Triangle(10, 10, 30, 10, 20, 20);
        t1.setStroke(false);
        t1.setFillColor(ColorSet.CYAN);
        t2.setStroke(false);
        t2.setFillColor(ColorSet.FIREBRICK);
        this.add(t1);
        this.add(t2);
      
    }

    @Override
    public void update() {}
}

public class RemoveExample extends Applet{
	
	Group tg1,tg2;
	Ellipse el;
	Rect r1,r2;
	MouseOverCallback removeover;

	@Override
	public void setup() {
		setSize(800,600);
		tg1 = new TriangleGroups();
		tg2 = new TriangleGroups();
		el = new Ellipse(10);
		r1 = new Rect(100, 100);
		r2 = new Rect(200, 120);
		r1.setFillColor(ColorSet.ALICE_BLUE);
		r2.setFillColor(ColorSet.CHOCOLATE);
		el.setFillColor(ColorSet.DARK_RED);
		tg1.setPosition(300,300);
		tg2.setPosition(600,400);
		el.setPosition(200, 100);
		r1.setPosition(700,200);
		r2.setPosition(200,500);
		
		addObject(tg1);
		addObject(tg2);
		addObject(el);
		addObject(r2);
		addObject(r1);
		removeover = new MouseOverCallback() {
			
			@Override
			public void run(MouseOverTypes eventtype, Element element) {
				if(eventtype == MouseOverTypes.ENTERED)
					element.remove();
				
			}
		};
		r2.addMouseEventCallback(removeover);		
		
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEvent(MouseEvent e, MouseButton b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyEvent(KeyEvent e) {
		if(e == KeyEvent.PRESSED){
			switch(getKey()){
			case 't':
				tg1.remove();
				break;
			case 'e':
				el.remove();
				break;
			case 'r':
				r1.remove();
				break;
			}
		}
		
	}
	
	public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.object.RemoveExample", "Remove Example");
    }


}
