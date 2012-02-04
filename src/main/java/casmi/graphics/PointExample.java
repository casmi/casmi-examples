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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.Color;
import casmi.graphics.element.Point;

/**
 * Example of Graphics.
 * 
 * @author K. Nishimura
 * 
 */
public class PointExample extends Applet {
    
    int numpoint = 1000;

    List<Point> points = new ArrayList<Point>();

    Random rnd = new Random();

    public void setup() {
        setSize(1024, 768);
        
        for (int i = 0; i < numpoint; i++) {
            Point p = new Point(200.0 + rnd.nextInt(500),
                                150.0 + rnd.nextInt(500));
            p.setStrokeColor(new Color(255, 255, 255));
            
            points.add(p);
            addObject(p);
        }
    }


    public static void main(String args[]) {
        AppletRunner.run("casmi.graphics.PointExample", "Example");
    }


	@Override
	public void mouseEvent(MouseEvent e, MouseButton b) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyEvent(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
